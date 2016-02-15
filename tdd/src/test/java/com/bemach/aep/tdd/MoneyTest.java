package com.bemach.aep.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}
	
	@Test
	public void tesFranctMultiplication() {
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

	@Test
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertTrue(new Dollar(6).equals(new Dollar(6)));
	}
	
}
