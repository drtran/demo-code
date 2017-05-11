package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class PMWindow implements Window {
	public PMWindow() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
