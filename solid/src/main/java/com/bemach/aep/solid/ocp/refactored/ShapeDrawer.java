package com.bemach.aep.solid.ocp.refactored;

import java.util.List;

/**
 * This refactored class is now agnostic about drawing.
 * We are using interface as a way to delegate the drawing 
 * to a specific class.
 * 
 * Another option is to used Template Method.
 * 
 *
 */
public class ShapeDrawer {

	public void drawAllShapes(List<Shape> shapes) {
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
}
