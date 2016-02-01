package com.bemach.aep.fitnesse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

public class JtracLoginUnitTest {

	@InjectMocks
	private JtracLoginTest target = new JtracLoginTest();
	
	@Test
	public void shouldGetCorrectPageTitleWhenAtHomePage() {
		target.websiteUrl = "http://pidev4:8080/jtrac/app";
		
		assertEquals("JTrac", target.pageTitle());
	}
}
