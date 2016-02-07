package com.bemach.aep.pisentry.zone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.Zone;

public class ZoneManagerImpl implements ZoneManager {

	private static Logger logger = Logger.getLogger(ZoneManagerImpl.class);
	private static ZoneManager instance = null;
	private List<Zone> zoneList = new ArrayList<Zone>();

	private ZoneManagerImpl() {
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	public void load(InputStream is) {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			String inputZone = br.readLine();
			if (inputZone == null)
				return;
			inputZone = inputZone.trim();
			if (inputZone.length() == 0) {
				return;
			}
			Zone zone = new Zone(inputZone);
			zoneList.add(zone);
		} catch (IOException e) {
			logger.error("Load zones exception: " + e);
		}
	}

	public void process(Event event) {
		// TODO Auto-generated method stub

	}

	public static ZoneManager getInstance() {
		if (instance == null) {
			instance = new ZoneManagerImpl();
		}
		return instance;
	}

	public void clear() {
		zoneList.clear();
	}

}
