package com.bemach.aep.designpatterns.creation.abstractfactory;

public class MotifWindow implements Window {
	public MotifWindow() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
