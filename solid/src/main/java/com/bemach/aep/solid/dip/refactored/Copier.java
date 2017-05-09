package com.bemach.aep.solid.dip.refactored;

public class Copier {
	private Reader reader;
	private Writer writer;

	public Copier(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void copy() {
		int c;
		while ((c = reader.read()) > 0) {
			writer.write(c);
		}
	}
}
