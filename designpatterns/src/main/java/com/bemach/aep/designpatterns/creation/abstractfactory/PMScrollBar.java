package com.bemach.aep.designpatterns.creation.abstractfactory;

public class PMScrollBar implements ScrollBar {
	public PMScrollBar() {
		System.out.println(this.getClass().getName() + ": constructs ...");
	}
}
