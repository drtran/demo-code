package com.bemach.aep.designpatterns.creation.abstractfactory;

public class PMWindow implements Window {
	public PMWindow() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
