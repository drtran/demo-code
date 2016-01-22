package com.bemach.csd.verifier.tomcat;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.hamcrest.CoreMatchers;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;

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