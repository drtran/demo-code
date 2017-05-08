package com.bemach.aep.solid.srp.refactored;

public class RectangleImpl extends GeometricRectangleImpl implements Rectangle {

	private Gui gui;

	public RectangleImpl() {
		System.out.println(this.getClass().getName() + ": Constructed");
		gui = new GuiImpl();
	}

	public void draw() {

	}
}
