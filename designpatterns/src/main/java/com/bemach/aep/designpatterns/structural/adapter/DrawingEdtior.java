package com.bemach.aep.designpatterns.structural.adapter;

public class DrawingEdtior {
	public static void main(String... args) {
		Shape line = ShapeFactory.makeLine();
		line.boundingBox();
		line.createManipulator();
		
		Shape textShape = ShapeFactory.makeTextShape();
		textShape.boundingBox();
		textShape.createManipulator();

	}
}
