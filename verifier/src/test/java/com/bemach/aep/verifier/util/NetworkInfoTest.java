package com.bemach.aep.verifier.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;



public class NetworkInfoTest {

	@InjectMocks
	private NetworkInfo target = new NetworkInfo();
	
	@Test
	public void shouldGetIpAddress() {
		assertNotNull("IpAddress is Null!", target.getIpAddresses());
	}
	
	@Test
	public void shouldHaveAtLeastOneIpAddresses() {
		List<String> ips = target.getIpAddresses();
		assertFalse(ips.isEmpty());
	}
	
	@Test
	public void getIpByHostName() throws UnknownHostException {
		InetAddress ia = InetAddress.getByName("Linksys35327");
		System.out.println("IP: " + ia.getHostAddress());
		
		ia = InetAddress.getByName("PiDev4");
		System.out.println("IP: " + ia.getHostAddress());

		ia = InetAddress.getByName("PiAlarm01");
		System.out.println("IP: " + ia.getHostAddress());

	}
	
}
