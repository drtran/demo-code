package com.bemach.aep.solid.dip.refactored;

public class PrinterWriter implements Writer {

	public void write(int c) {
		System.out.println("printer writing " + c);
	}

}
