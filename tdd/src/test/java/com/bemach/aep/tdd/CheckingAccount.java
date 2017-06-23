package com.bemach.aep.tdd;

public class CheckingAccount {

	private Integer balance = Integer.valueOf(0);

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(int i) {
		// TODO Auto-generated method stub

	}

	public void deposit(int depositValue) {
		balance = depositValue;
	}

}
