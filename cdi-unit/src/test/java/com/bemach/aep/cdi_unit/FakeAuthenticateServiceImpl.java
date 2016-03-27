package com.bemach.aep.cdi_unit;

import javax.enterprise.inject.Alternative;

@Alternative
public class FakeAuthenticateServiceImpl implements AuthenticateService {

	public String authenticate() {
		return "FALSE";
	}

}
