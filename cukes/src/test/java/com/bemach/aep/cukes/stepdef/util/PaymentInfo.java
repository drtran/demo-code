package com.bemach.aep.cukes.stepdef.util;

public class PaymentInfo {

	private String name;
	private String address;
	private String email;
	private String payType;

	public PaymentInfo(String name, String address, String email, String payType) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.payType = payType;
	}

	public PaymentInfo() {
		
	}

	public CharSequence getName() {
		return name;
	}

	public CharSequence getAddress() {
		return address;
	}

	public CharSequence getEmail() {
		return email;
	}

	public Object getPayType() {
		return payType;
	}

}
