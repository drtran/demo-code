package com.drkiettran.aep.refactoring;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	public static final String EMPTY_STMT = "Rental Record for Johnny\n"
			+ "Amount owed is 0.0\nYou earned 0 frequent renter points";

	public static final String ONE_RENTAL_STMT = "Rental Record for Johnny\n" + "\tRaider of the lost art	2.0\n"
			+ "Amount owed is 2.0\nYou earned 1 frequent renter points";

	public static final String TWO_RENTAL_STMT = "Rental Record for Johnny\n\tRaider of the lost art	2.0\n\tChristmas	1.5\nAmount owed is 3.5\nYou earned 2 frequent renter points";

	public static final String THREE_RENTAL_STMT = "Rental Record for Johnny\n\tRaider of the Lost Ark	3.5\n\tChristmas	3.0\n\tMidnight Express	6.0\nAmount owed is 12.5\nYou earned 4 frequent renter points";

	private Customer customer;

	@Before
	public void setUp() {
		customer = new Customer("Johnny");
	}

	@Test
	public void empty_statement_when_no_rental_exists() {
		assertThat("", customer.statement(), equalTo(EMPTY_STMT));
	}

	@Test
	public void not_empty_statement_when_one_rental_exists() {
		customer.addRental(new Rental(new Movie("Raider of the lost art", Movie.REGULAR), 1));
		assertThat("", customer.statement(), equalTo(ONE_RENTAL_STMT));
	}

	@Test
	public void not_empty_statement_when_two_rental_exists() {
		customer.addRental(new Rental(new Movie("Raider of the lost art", Movie.REGULAR), 1));
		customer.addRental(new Rental(new Movie("Christmas", Movie.CHILDRENS), 1));
		assertThat("", customer.statement(), equalTo(TWO_RENTAL_STMT));
	}

	@Test
	public void not_empty_statement_when_three_rental_exists() {
		customer.addRental(new Rental(new Movie("Raider of the Lost Ark", Movie.REGULAR), 3));
		customer.addRental(new Rental(new Movie("Christmas", Movie.CHILDRENS), 4));
		customer.addRental(new Rental(new Movie("Midnight Express", Movie.NEW_RELEASE), 2));
		System.out.println(customer.statement());
		assertThat("", customer.statement(), equalTo(THREE_RENTAL_STMT));
	}
}
