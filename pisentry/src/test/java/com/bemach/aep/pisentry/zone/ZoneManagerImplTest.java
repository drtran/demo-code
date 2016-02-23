package com.bemach.aep.pisentry.zone;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bemach.aep.pisentry.vos.Zone;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ZoneManagerImplTest {

	private ZoneManager target = ZoneManagerImpl.getInstance();

	@Before
	public void setUp() {
		target.clear();
	}

	@Test
	public void shouldBeEmptyWhenStarted() {
		List<Zone> zoneList = target.getZoneList();
		assertEquals(0, zoneList.size());
	}

	@Test
	public void shouldLoadAnEmptyZoneListFromInputStream() {
		target.load(new ByteArrayInputStream("".getBytes()));
		List<Zone> zoneList = target.getZoneList();
		assertEquals(0, zoneList.size());
	}

	@Test
	@Parameters(method = "inputValues")
	public void shouldLoadOneItemZoneFromInputStream(String input) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
		target.load(bais);
		bais.close(); 
		List<Zone> zoneList = target.getZoneList();
		assertEquals(1, zoneList.size());
		assertEquals(input, zoneList.get(0).toString());
	}

	private Object[] inputValues() {
		return new Object[] { 
				new Object[] { "57,Garrage-Left,REED,Left Garage Door,06-12-2015" },
				new Object[] { "58,Garrage-Right,REED,Right Garage Door,06-02-2016" } };
	}
}
