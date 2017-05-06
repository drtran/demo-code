package com.bemach.aep.solid.srp;

/**
 * When you run this application, you will see the following console output:
 * 
 * com.bemach.aep.solid.srp.GraphicalApplication: runs
 * com.bemach.aep.solid.srp.RectangleImpl: Constructed
 * com.bemach.aep.solid.srp.GuiImpl: Constructed
 * com.bemach.aep.solid.srp.AreaImpl: Constructed
 * 
 */
public class GraphicalApplication {
	public static void main(String... args) {
		System.out.println(GraphicalApplication.class.getName() + ": runs");
		Rectangle rect = new RectangleImpl();
	}
}
