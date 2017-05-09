package com.bemach.aep.solid.dip.refactored;

public class FileReader implements Reader {
	private static int c = 'b';

	public int read() {
		System.out.println("file reading ... ");
		int retC;

		if (c > 0) {
			retC = c;
			c = 0;
		} else {
			retC = c;
		}
		return retC;
	}

}
