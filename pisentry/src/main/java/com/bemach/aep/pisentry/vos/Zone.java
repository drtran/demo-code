package com.bemach.aep.pisentry.vos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class Zone {
	private static Logger logger = Logger.getLogger(Zone.class);
	private String id;
	private String name;
	private ZoneType type;
	private String description;
	private ZoneState state;
	private Event lastEvent;
	private long lastUpdate;
	private Date installedDate;

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
		this.installedDate = getDate(st.nextToken());
	}

	private Date getDate(String dateStr) {
		Date date = null;
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			logger.error("ERROR: " + e);
		}
		return date;
	}

	public String toString() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(installedDate);
		return String.format("%s,%s,%s,%s,%02d-%02d-%d", id, name, type, description, cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
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

	public Date getInstalledDate() {
		return installedDate;
	}

}
