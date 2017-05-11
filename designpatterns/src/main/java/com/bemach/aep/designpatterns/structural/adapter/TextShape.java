package com.bemach.aep.designpatterns.structural.adapter;

public class TextShape implements Shape {

	private TextView textView;

	public TextShape() {
		textView = new TextView();
	}

	public void boundingBox() {
		String text = textView.getExtent();
		System.out.println(this.getClass().getName() + ": " + text + " ...");
	}

	public void createManipulator() {
		System.out.println(this.getClass().getName() + ": creates manipulator ...");

	}

}
