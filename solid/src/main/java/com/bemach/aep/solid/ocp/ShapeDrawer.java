package com.bemach.aep.solid.ocp;

import java.util.List;

/**
 * The problem with this implementation is that the drawAllShapes method must be
 * changed each time a new shape is requested for support (i.e. Triangle)
 *
 */
public class ShapeDrawer {

	public void drawAllShapes(List<Object> shapes) {
		for (Object shape : shapes) {
			if (shape instanceof Square) {
				drawSquare((Square) shape);
			} else if (shape instanceof Circle) {
				drawCircle((Circle) shape);
			} else {
				System.err.println(shape.getClass().getName() + ": Sorry no drawing for this shape");
			}
		}
	}

	private void drawCircle(Circle circle) {
		System.out.println(circle.getClass().getName() + ": drawing ...");
	}

	private void drawSquare(Square square) {
		System.out.println(square.getClass().getName() + ": drawing ...");
	}
}
