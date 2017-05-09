package com.bemach.aep.solid.dip.refactored;

public class NetworkWriter implements Writer {

	public void write(int c) {
		System.out.println("network writing " + c);
	}

}
