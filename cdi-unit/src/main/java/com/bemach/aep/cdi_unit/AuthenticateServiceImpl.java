package com.bemach.aep.cdi_unit;

public class AuthenticateServiceImpl implements AuthenticateService {
	public String authenticate() {
		System.out.println("authenticates ...");
		return "TRUE";
	}
}
