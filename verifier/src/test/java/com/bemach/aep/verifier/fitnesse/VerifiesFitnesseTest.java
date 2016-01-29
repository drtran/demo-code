package com.bemach.aep.verifier.fitnesse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerifiesFitnesseTest {
	
	@InjectMocks
	VerifiesFitnesse target;
	
	
	@Test
	public void shouldGetFitnesseDefaultPageTitle() {
		String actualTitle = target.getPageTitle();
		assertTrue(actualTitle.contains("FrontPage"));
	}
}
