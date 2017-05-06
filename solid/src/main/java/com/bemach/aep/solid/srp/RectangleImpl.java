package com.bemach.aep.solid.srp;

public class RectangleImpl implements Rectangle {

	private Gui gui;
	private Area area;

	public RectangleImpl() {
		System.out.println(this.getClass().getName() + ": Constructed");
		gui = new GuiImpl();
		area = new AreaImpl();
	}

	public void draw() {

	}

	public double area() {
		return area.compute();
	}

}
