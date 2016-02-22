package com.bemach.aep;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.bemach.aep.Calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculatorWithJUnitParamsTest {
	
	@Test
	@Parameters({
		"2, 1, 1", 
		"9, -1, 10",
		"-3, -2, -1",
		"-5, 1, -6",
		"0, 0, 0"})
	public void shouldAddTwoIntegers(int expected, int value1, int value2) {
		Calculator calculator = new Calculator();
		int result = calculator.add (value1, value2);
		assertEquals(expected, result);
	}
	
	@Test 
	public void shouldDivideTwoIntegers() {
		Calculator cal = new Calculator();
		
		int result = cal.divide(100, 20);
		int expected = 5;
		
		assertEquals(expected, result);
	}
}
