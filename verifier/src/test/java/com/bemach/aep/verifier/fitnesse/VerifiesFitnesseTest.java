package com.bemach.aep.verifier.fitnesse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Make sure fitnesse is running on the localhost:9090
 * 
 * Run with Maven command line:
 * mvn test -Dtest=com.bemach.aep.verifier.fitnesse.VerifiesFitnesseTest -Dfitnesse-url=http://localhost:9090
 * 
 * @author ktran
 *
 */
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
