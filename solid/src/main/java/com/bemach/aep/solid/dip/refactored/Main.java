package com.bemach.aep.solid.dip.refactored;

public class Main {
	public static void main(String... args) {
		Copier copier = new Copier(new KeyboardReader(), new PrinterWriter());
		copier.copy();

		copier = new Copier(new FileReader(), new NetworkWriter());
		copier.copy();
	}
}
