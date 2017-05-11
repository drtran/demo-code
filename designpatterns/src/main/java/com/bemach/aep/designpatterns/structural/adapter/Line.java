package com.bemach.aep.designpatterns.structural.adapter;

public class Line implements Shape {

	public Line() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}

	public void boundingBox() {
		System.out.println(this.getClass().getName() + ": bounding box ...");
	}

	public void createManipulator() {
		System.out.println(this.getClass().getName() + ": creates manipulator ...");

	}

}
