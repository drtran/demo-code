package com.bemach.aep.solid.srp.refactored;

/**
 * 
 * When you run this application, you will see the following console output:
 * 
 * com.bemach.aep.solid.srp.refactor.GraphicalApplication: runs
 * com.bemach.aep.solid.srp.refactor.RectangleImpl: Constructed
 * com.bemach.aep.solid.srp.refactor.AreaImpl: Constructed
 * com.bemach.aep.solid.srp.refactor.RectangleImpl: Constructed
 * com.bemach.aep.solid.srp.refactor.GuiImpl: Constructed
 *
 * 
 */
public class GraphicalApplication {
	public static void main(String... args) {
		System.out.println(GraphicalApplication.class.getName() + ": runs");
		Rectangle rect = new RectangleImpl();
	}
}
