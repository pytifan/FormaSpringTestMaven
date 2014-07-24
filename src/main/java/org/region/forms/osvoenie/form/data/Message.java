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

public class Message implements Comparable<Message> {

	private final String name;
	private final long time;
	private final String matchTime;
	private final String messageText;

	public Message() {
		name = "";
		time = 0L;
		matchTime = "00:00";
		messageText = "";
	}

	public Message(String name, long time, String messageText, String matchTime) {
		this.name = name;
		this.time = time;
		this.messageText = messageText;
		this.matchTime = matchTime;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object
	 */
	@Override
	public int compareTo(Message compareTime) {

		int retVal = (int) (time - compareTime.time);

		return retVal;
	}

	@Override
	public String toString() {
		return matchTime + " - " + name + " - " + messageText;
	}

	public String getName() {
		return name;
	}

	public String getMessageText() {
		return messageText;
	}

	public long getTime() {
		return time;
	}

	public String getMatchTime() {
		return matchTime;
	}

}