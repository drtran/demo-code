package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class MotifWidgetFactory {

	public static Window createWindow() {
		return new MotifWindow();
	}

	public static ScrollBar createScrollBar() {
		return new MotifScrollBar();
	}

}
