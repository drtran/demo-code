package com.bemach.csd.verifier.sonarqube;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class VerifiesSonarQubeTest {

	@InjectMocks
	VerifiesSonarQube subject;

	@Test
	public void shouldGetSonarQubePageTitle() {
		String actualTitle = subject.getPageTitle();
		assertEquals(actualTitle, "SonarQube");
	}
}