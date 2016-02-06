package com.bemach.aep.pisentry.vos;

import java.util.Date;

public class Zone {
	public Zone(String inputZone) {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String name;
	private ZoneType type;
	private String description;
	private Date installedDate;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ZoneType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public Date getInstalledDate() {
		return installedDate;
	}

}
