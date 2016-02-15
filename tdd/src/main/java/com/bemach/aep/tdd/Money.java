package com.bemach.aep.tdd;

public abstract class Money {

	protected int amount;

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && getClass().equals(money.getClass());
	}

	public static Dollar dollar(int amount) {
		return new Dollar(amount); 
	}

	public static Franc franc(int amount) {
		return new Franc(amount);
	}

	abstract public Money times(int multiplier);
	abstract public String currency();
}
