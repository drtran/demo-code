package com.bemach.aep.pisentry.vos;

public class Event {
	public enum EVENT_TYPE {ZONE_EVENT, USER_EVENT, ADMIN_EVENT, NOTIFICATION_EVENT}
	private String id;
	private String name;
	private String description;
	private EVENT_TYPE type;
	private String message; // USER_TOKEN:EVENT_TYPE:EVENT_DATA
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EVENT_TYPE getType() {
		return type;
	}
	public void setType(EVENT_TYPE type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
