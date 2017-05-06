package com.bemach.aep.solid.srp.refactor;

public class GeometricRectangleImpl implements GeometricRectangle {
	private Area area;

	public GeometricRectangleImpl() {
		super();
		System.out.println(this.getClass().getName() + ": Constructed");
		area = new AreaImpl();
	}

	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}
