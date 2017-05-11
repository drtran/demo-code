package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class PMWidgetFactory {

	public static Window createWindow() {
		return new PMWindow();
	}

	public static ScrollBar createScrollBar() {
		return new PMScrollBar();
	}

}
