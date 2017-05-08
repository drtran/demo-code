package com.bemach.aep.solid.ocp.refactored;

public class Square implements Shape {

	public void draw() {
		System.out.println(this.getClass().getName() + ": draws ...");
	}

}
