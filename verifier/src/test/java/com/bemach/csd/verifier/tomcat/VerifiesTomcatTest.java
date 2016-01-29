package com.bemach.csd.verifier.tomcat;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * NOTES: 
 * 
 * Do not use CDI Unit test along with Selenium related tests because of some conflict.
 * Web driver cannot launch ...
 * 
 * @author ktran
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class VerifiesTomcatTest {

	@InjectMocks
	VerifiesTomcat subject;

	@Test
	public void shouldGetTomcateDefaultPageTitle() {
		String actualTitle = subject.getPageTitle();
		assertTrue(actualTitle.contains("Apache Tomcat"));
	}
	
	@Test
	public void shouldGetJenkinsPageTitle() {
		String actualTitle = subject.getJenkinsPageTitle();
		assertTrue(actualTitle.contains("Dashboard"));
	}
	
	@Test
	public void shouldGetJtracPageTitle() {
		String actualTitle = subject.getJtracPageTitle();
		assertTrue(actualTitle.contains("JTrac"));
	}
}