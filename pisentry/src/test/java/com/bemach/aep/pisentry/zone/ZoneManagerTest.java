package com.bemach.aep.pisentry.zone;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.bemach.aep.pisentry.vos.Zone;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
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
	@Parameters(method = "inputValues")
	public void shouldLoadOneItemZoneFromInputStream(String input) throws IOException {
		ZoneManager target = new ZoneManagerImpl();
		ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
		target.load(bais);
		bais.close();
		List<Zone> zoneList = target.getZoneList();
		assertEquals(1, zoneList.size());
		assertEquals(input, zoneList.get(0).toString());
	}

	private Object[] inputValues() {
		return new Object[] { new Object[] { "57,Garrage-Left,REED,Left Garage Door,06-FEB-2016" },
				new Object[] { "58,Garrage-Right,REED,Left Garage Door,06-FEB-2016" } };
	}
}
