package com.bemach.aep.solid.dip.refactored;

public class KeyboardReader implements Reader {
	private static int c = 'a';

	public int read() {
		int retC;

		System.out.println("keyboard reading ... ");

		if (c > 0) {
			retC = c;
			c = 0;
		} else {
			retC = c;
		}
		return retC;
	}

}
