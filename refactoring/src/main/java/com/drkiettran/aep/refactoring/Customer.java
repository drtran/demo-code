package com.drkiettran.aep.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int freqRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for ").append(name).append('\n');

		for (Rental rental : rentals) {
			double thisAmount = 0;

			// determine amounts for each line
			switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (rental.getDaysRented() > 2) {
					thisAmount += (rental.getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += rental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (rental.getDaysRented() > 3) {
					thisAmount += (rental.getDaysRented() - 3) * 1.5;
				}
				break;
			}

			// add frequent renter points
			freqRenterPoints += 1;

			// add bonus for a two day new release rental
			if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
				freqRenterPoints += 1;
			}

			// show figures for this rental
			result.append('\t').append(rental.getMovie().getTitle());
			result.append('\t').append(thisAmount).append('\n');
			totalAmount += thisAmount;

		}
		result.append("Amount owed is ").append(totalAmount).append('\n');
		result.append("You earned ").append(freqRenterPoints).append(" frequent renter points");
		return result.toString();
	}

	public String getName() {
		return name;
	}
}
