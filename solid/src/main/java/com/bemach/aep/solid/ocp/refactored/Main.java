package com.bemach.aep.solid.ocp.refactored;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String... args) {
		ShapeDrawer shapeDrawer = new ShapeDrawer();
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle());
		shapes.add(new Square());
		shapes.add(new Triangle());

		shapeDrawer.drawAllShapes(shapes);
	}
}
