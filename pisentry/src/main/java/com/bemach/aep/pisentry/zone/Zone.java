package com.bemach.aep.pisentry.zone;

import java.util.Date;

public class Zone {
	private enum ZONE_TYPE {REED_SWITCH, MOTION, FIRE, CO2, TEMPERATURE, HUMIDITY, GAS}
	private String id;
	private String name;
	private String description;
	private ZONE_TYPE type;
	private Date lastReportedDate;
	private String lastReportMessage;
	
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
	public ZONE_TYPE getType() {
		return type;
	}
	public void setType(ZONE_TYPE type) {
		this.type = type;
	}
	public Date getLastReportedDate() {
		return lastReportedDate;
	}
	public void setLastReportedDate(Date lastReportedDate) {
		this.lastReportedDate = lastReportedDate;
	}
	public String getLastReportMessage() {
		return lastReportMessage;
	}
	public void setLastReportMessage(String lastReportMessage) {
		this.lastReportMessage = lastReportMessage;
	}
	
	
}
