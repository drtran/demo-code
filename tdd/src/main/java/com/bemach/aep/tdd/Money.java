package com.bemach.aep.tdd;

public abstract class Money {

	protected int amount;
	protected String currency;

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && getClass().equals(money.getClass());
	}

	public static Money dollar(int amount) {
		return new Dollar(amount); 
	}

	public static Money franc(int amount) {
		return new Franc(amount);
	}

	abstract public Money times(int multiplier);
	public String currency() {
		return currency;
	}
}
