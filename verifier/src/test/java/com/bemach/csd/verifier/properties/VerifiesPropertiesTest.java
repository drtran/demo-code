package com.bemach.csd.verifier.properties;

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
public class VerifiesPropertiesTest {

	@InjectMocks
	VerifiesProperties subject;

	@Test
	public void shouldFindAllRequiredProperties() {
		
	}
}
