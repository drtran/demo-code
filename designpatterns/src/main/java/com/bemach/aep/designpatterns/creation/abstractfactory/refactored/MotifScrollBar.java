package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class MotifScrollBar implements ScrollBar {
	public MotifScrollBar() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
