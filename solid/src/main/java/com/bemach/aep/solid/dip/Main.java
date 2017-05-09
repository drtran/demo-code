package com.bemach.aep.solid.dip;

public class Main {
	public static void main (String ... args) {
		KeyboardReader keyboardReader = new KeyboardReader();
		PrinterWriter printerWriter = new PrinterWriter();
		copy (keyboardReader, printerWriter);
	}

	private static void copy(KeyboardReader keyboardReader, PrinterWriter printerWriter) {
		int c;
		while ((c = keyboardReader.read()) > 0) {
			printerWriter.write(c);
		}
	}
}
