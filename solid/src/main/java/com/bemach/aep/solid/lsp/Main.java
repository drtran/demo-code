package com.bemach.aep.solid.lsp;

public class Main {
	public static void main(String[] args) {
		Rectangle rec = getRectangle();
		rec.setHeight(7);
		rec.setWidth(3);
		System.out.println("An area of a rectangle should be 3x7=21; however it is " + rec.getArea());
	}

	/**
	 * 
	 * Liskov Substitute Principle states: What is wanted here is something like
	 * the following substitution property: If for each object o1 of type S
	 * there is an object o2 of type T such that for all programs P defined in
	 * term of T, the behavior of P is unchanged when o1 is substituted for o2
	 * then S is a subtype of T
	 * 
	 * Restated for our case where Square is a subtype of Rectangle.
	 * 
	 * If for each object square of type Square there is an object rectangle of
	 * type Rectangle such that for all programs P defined in term of Rectangle,
	 * the behavior of P is unchanged when square is substituted for rectangle
	 * then Square is a subtype of Rectangle
	 * 
	 * 
	 * @return
	 */
	public static Rectangle getRectangle() {
		return new Square();
	}

}
