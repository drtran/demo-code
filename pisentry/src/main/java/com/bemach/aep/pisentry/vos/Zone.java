package com.bemach.aep.pisentry.vos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class Zone {
	private static Logger logger = Logger.getLogger(Zone.class);
	private String id;
	private String name;
	private ZoneType type;
	private String description;
	private String installedDate;

	/**
	 * "ID,NAME,TYPE,DESCRIIPTION,DD-MMM-YYYY"
	 * 
	 * @param inputZone
	 */
	public Zone(String inputZone) {
		StringTokenizer st = new StringTokenizer(inputZone.trim(), ",");
		if (st.countTokens() != 5) {
			logger.error(String.format("Invalid input zone item from zone list: %s", inputZone));
		}
		this.id = st.nextToken();
		this.name = st.nextToken();
		this.type = ZoneType.valueOf(st.nextToken());
		this.description = st.nextToken();
		this.installedDate = st.nextToken();
	}

	public String toString() {
		return String.format("%s,%s,%s,%s,%s", id, name, type, description, installedDate);
	}

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

	public String getInstalledDate() {
		return installedDate;
	}

}
