package com.bemach.aep.utility.refactoring;

public class ExtractMethod {
	void printOwing() {
		String name = "John Doe";
		printBanner(); // print details
		System.out.println("name: " + name );
		System.out.println("amount: " + getOutstanding());
	}

	private String getOutstanding() {
		return "100";
	}

	private void printBanner() {
		System.out.println("**** BANNER ****");
	}

}
