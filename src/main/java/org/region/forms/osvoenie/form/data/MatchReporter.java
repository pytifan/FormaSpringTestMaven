/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.form.data;

/**
 *
 * @author alexey
 */
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.region.forms.osvoenie.service.Hook;
import org.region.forms.osvoenie.service.ShutdownService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Models a reporter at the match. The reporter knows about the match and sends updates to the
 * queue at the appropriate moment.
 * 
 * @author Roger
 * 
 *         Created 12:08:31 10 Feb 2013
 * 
 */
public class MatchReporter implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(MatchReporter.class);

	private final Match match;

	private final Queue<Message> queue;

	private volatile boolean start = true;

	@Autowired
	private ShutdownService shutdownService;

	private Hook hook;

	public MatchReporter(Match theBigMatch, Queue<Message> queue) {
		this.match = theBigMatch;
		this.queue = queue;
	}

	/**
	 * Called by Spring after loading the context. Will "kick off" the match...
	 */
	public void start() {

		if (start) {
			synchronized (this) {
				if (start) {
					start = false;
					logger.info("Starting the Match Reporter...");
					String name = match.getName();
					Thread thread = new Thread(this, name);
					hook = shutdownService.createHook(thread);

					thread.start();
				}
			}
		} else {
			logger.warn("Game already in progress");
		}
	}

	/**
	 * The main run loop
	 */
	@Override
	public void run() {

		sleep(5); // Sleep to allow the reset of the app to load

		logger.info("The match has now started...");
		long now = System.currentTimeMillis();
		List<Message> matchUpdates = match.getUpdates();

		for (Message message : matchUpdates) {

			delayUntilNextUpdate(now, message.getTime());
			if (!hook.keepRunning()) {
				break;
			}
			logger.info("Add message to queue: {}", message.getMessageText());
			queue.add(message);
		}
		start = true; // Game over, can restart
		logger.warn("GAME OVER");
	}

	private void sleep(int deplay) {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			logger.info("Sleep interrupted...");
		}
	}

	private void delayUntilNextUpdate(long now, long messageTime) {

		while (System.currentTimeMillis() < now + messageTime) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				logger.info("MatchReporter Thread interrupted...");
			}
		}
	}

}
