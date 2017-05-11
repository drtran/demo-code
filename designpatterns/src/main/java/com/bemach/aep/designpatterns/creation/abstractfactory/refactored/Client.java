package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class Client {
	public static void main(String... args) {
		Window pmWindow = WidgetFactory.createWindow(WidgetFactory.WindowType.PMWindow);
		Window motifWindow = WidgetFactory.createWindow(WidgetFactory.WindowType.MotifWindow);
		ScrollBar pmScrollBar = WidgetFactory.createScrollBar(WidgetFactory.ScrollBarType.PMScrollBar);
		ScrollBar motifScrollBar = WidgetFactory.createScrollBar(WidgetFactory.ScrollBarType.MotifScrollBar);
	}
}
