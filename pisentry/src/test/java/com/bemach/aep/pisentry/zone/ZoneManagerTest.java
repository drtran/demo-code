package com.bemach.aep.pisentry.zone;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.bemach.aep.pisentry.vos.Zone;

public class ZoneManagerTest {
	@Test
	public void shouldBeEmptyWhenStarted() {
		ZoneManager target = new ZoneManagerImpl();
		List<Zone> zoneList = target.getZoneList();
		assertEquals(0, zoneList.size());
	}

	@Test
	public void shouldLoadAnEmptyZoneListFromInputStream() {
		ZoneManager target = new ZoneManagerImpl();
		target.load(new ByteArrayInputStream("".getBytes()));
		List<Zone> zoneList = target.getZoneList();
		assertEquals(0, zoneList.size());
	}

	@Test
	public void shouldLoadOneItemZoneFromInputStream() throws IOException {
		ZoneManager target = new ZoneManagerImpl();
		ByteArrayInputStream bais = new ByteArrayInputStream("57,Garrage-Left,REED,Left Garage Door".getBytes());
		target.load(bais);
		bais.close();
		List<Zone> zoneList = target.getZoneList();
		assertEquals(1, zoneList.size());
	}
}
