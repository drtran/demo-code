package com.bemach.aep.verifier.util;

import static org.junit.Assert.assertNotNull;
import org.fest.assertions.*;
import java.util.List;

import javax.inject.Inject;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class NetworkInfoTest {

	@Inject
	private NetworkInfo target;
	
	@Test
	public void shouldGetIpAddress() {
		assertNotNull("IpAddress is Null!", target.getIpAddresses());
	}
	
	@Test
	public void shouldHaveAtLeastOneIpAddresses() {
		List<String> ips = target.getIpAddresses();
		Assertions.assertThat(ips).isNotEmpty();
	}
	
}
