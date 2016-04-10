package com.bemach.aep.cdiunit;

import javax.enterprise.inject.Alternative;

import com.bemach.aep.cdiunit.AuthenticateService;

@Alternative
public class FakeAuthenticateServiceImpl implements AuthenticateService {

	public String authenticate() {
		return "FALSE";
	}

}
