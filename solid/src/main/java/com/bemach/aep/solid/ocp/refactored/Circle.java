package com.bemach.aep.solid.ocp.refactored;

public class Circle implements Shape {

	public void draw() {
		System.out.println(this.getClass().getName() + ": draws ...");
	}

}
