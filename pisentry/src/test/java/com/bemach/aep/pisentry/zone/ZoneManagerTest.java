package com.bemach.aep.pisentry.zone;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.bemach.aep.pisentry.vos.Zone;

public class ZoneManagerTest {
	@Test
	public void shouldBeEmptyWhenStarted() {
		ZoneManager target = new ZoneManagerImpl();
		List<Zone> zoneList = target.getZoneList();
		assertEquals(0, zoneList.size());
	}
}
