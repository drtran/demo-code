package com.bemach.aep.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckingAccountTest {

	@Test
	public void zero_dollar_in_balance_when_first_created() {

	}

	@Test
	public void shouldHaveZeroInBalanceWHenFirstCreated() {
		CheckingAccount checkingAccount = new CheckingAccount(); // Arrange
															

		Integer acutalBalance = checkingAccount.getBalance(); // Act [When]
		Integer expectedBalance = 0;

		assertEquals(expectedBalance, acutalBalance); // Assertion
	}

	@Test
	public void shouldHaveBalanceEqualsToDeposit() {
		CheckingAccount checkingAccount = new CheckingAccount(); // Arrange
		checkingAccount.setBalance(0);
		
		checkingAccount.deposit(100);
		
		Integer acutalBalance = checkingAccount.getBalance(); // Act [When]
		Integer expectedBalance = 100;
		
		assertEquals(expectedBalance, acutalBalance);
	}
}
