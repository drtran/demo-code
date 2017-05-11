package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class PMScrollBar implements ScrollBar {
	public PMScrollBar() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
