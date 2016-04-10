package com.bemach.aep.cdiunit;

public class AuthenticateServiceImpl implements AuthenticateService {
	public String authenticate() {
		System.out.println("authenticates ...");
		return "TRUE";
	}
}
