/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.region.forms.osvoenie.form.data.MatchReporter;
import org.region.forms.osvoenie.form.data.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service("DeferredService")
public class DeferredResultService implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(DeferredResultService.class);

	private final BlockingQueue<DeferredResult<Message>> resultQueue = new LinkedBlockingQueue<>();

	private Thread thread;

	private volatile boolean start = true;

	@Autowired
	private ShutdownService shutdownService;

	private Hook hook;

	@Autowired
	@Qualifier("theQueue")
	private LinkedBlockingQueue<Message> queue;

	@Autowired
	@Qualifier("BillSkyes")
	private MatchReporter matchReporter;

	public void subscribe() {
		logger.info("Starting server");
		matchReporter.start();
		startThread();
	}

	private void startThread() {

		if (start) {
			synchronized (this) {
				if (start) {
					start = false;
					thread = new Thread(this, "Studio Teletype");
					hook = shutdownService.createHook(thread);
					thread.start();
				}
			}
		}
	}

	@Override
	public void run() {

		logger.info("DeferredResultService - Thread running");
		while (hook.keepRunning()) {
			try {
				DeferredResult<Message> result = resultQueue.take();
				Message message = queue.take();
				result.setResult(message);
			} catch (InterruptedException e) {
				System.out.println("Interrupted when waiting for latest update. "
						+ e.getMessage());
			}
		}
		System.out.println("DeferredResultService - Thread ending");
	}

	public void getUpdate(DeferredResult<Message> result) {
		resultQueue.add(result);
	}

}
