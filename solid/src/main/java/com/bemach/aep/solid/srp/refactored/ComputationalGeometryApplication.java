package com.bemach.aep.solid.srp.refactored;

/**
 * 
 * When you run this application, you will see the following console output:
 * 
 * com.bemach.aep.solid.srp.refactor.ComputationalGeometryApplication: runs
 * com.bemach.aep.solid.srp.refactor.GeometricRectangleImpl: Constructed
 * com.bemach.aep.solid.srp.refactor.AreaImpl: Constructed
 * 
 */
public class ComputationalGeometryApplication {
	public static void main(String... args) {
		System.out.println(ComputationalGeometryApplication.class.getName() + ": runs");
		GeometricRectangle rect = new GeometricRectangleImpl();
	}
}
