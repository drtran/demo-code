package com.bemach.aep.solid.srp;

/**
 * When you run this application, you will see the following console output:
 * 
 * com.bemach.aep.solid.srp.ComputationalGeometryApplication: runs
 * com.bemach.aep.solid.srp.RectangleImpl: Constructed
 * com.bemach.aep.solid.srp.GuiImpl: Constructed <------- Not really needed
 * com.bemach.aep.solid.srp.AreaImpl: Constructed
 *
 */
public class ComputationalGeometryApplication {
	public static void main(String... args) {
		System.out.println(ComputationalGeometryApplication.class.getName() + ": runs");
		Rectangle rect = new RectangleImpl();
	}
}
