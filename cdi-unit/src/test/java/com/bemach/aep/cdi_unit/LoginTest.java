package com.bemach.aep.cdi_unit;

import static org.junit.Assert.assertNotNull;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(FakeAuthenticateServiceImpl.class)
public class LoginTest {
	@Inject
	private Login target;

	@Produces
	@Mock
	private AuthenticateServiceImpl authenticateSvc;

	@Before
	public void setUp() {
		Mockito.when(authenticateSvc.authenticate()).thenReturn("FALSE");
	}

	@Test
	public void shouldCreateInstance() {

		assertNotNull("Failed to create object.", target);
	}
}
