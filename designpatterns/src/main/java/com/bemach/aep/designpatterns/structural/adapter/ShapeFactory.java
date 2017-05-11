package com.bemach.aep.designpatterns.structural.adapter;

public class ShapeFactory {
	public static Shape makeLine() {
		return new Line();
	}

	public static Shape makeTextShape() {
		return new TextShape();
	}
}
