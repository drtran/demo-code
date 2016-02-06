package com.bemach.aep.pisentry.zone;

import java.io.InputStream;
import java.util.List;

import com.bemach.aep.pisentry.vos.Zone;

public interface ZoneManager {

	public List<Zone> getZoneList();

	public void load(InputStream inputStream);

}
