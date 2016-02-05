package com.bemach.aep.pisentry.vos;

import java.util.StringTokenizer;

/**
 * 
 * // ID:EVENT_TYPE:EVENT_DATA
 * 
 * @author ktran
 *
 */
public class Event {
	private String id = null;
	private EventType type = null;
	private String data = null;

	public Event(String id, EventType type, String data) {
		this.id = id;
		this.type = type;
		this.data = data;
	}

	public Event(String msg) {
		StringTokenizer st = new StringTokenizer(msg, ":");

		// ID:EVENT_TYPE:EVENT_DATA
		if (st.countTokens() == 3) {
			this.setId(st.nextToken());
			this.setType(EventType.valueOf(st.nextToken()));
			this.setMessage(st.nextToken());
		} else {
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public String getMessage() {
		return data;
	}

	public void setMessage(String message) {
		this.data = message;
	}

	public String toString() {
		return String.format("%s:%s:%s", id, type, data);
	}

}
