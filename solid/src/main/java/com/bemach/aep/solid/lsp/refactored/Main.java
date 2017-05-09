package com.bemach.aep.solid.lsp.refactored;

public class Main {
	public static void main(String[] args) {
		Quadrilaterals quad = getQuadrilaterals();
		quad.setHeight(7);
		quad.setWidth(3);
		System.out.println("Rectangle area 7x3 =" + quad.getArea());
		quad = getSquare(7);
		System.out.println("Square area 7x7 =" + quad.getArea());
	}

	public static Quadrilaterals getQuadrilaterals() {
		return new Square();
	}

	public static Quadrilaterals getSquare(int widthHeight) {
		Square square = new Square();
		square.setWidthAndHeight(widthHeight);
		return square;
	}
}
