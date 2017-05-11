package com.bemach.aep.designpatterns.creation.abstractfactory;

public class MotifScrollBar implements ScrollBar {
	public MotifScrollBar() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
