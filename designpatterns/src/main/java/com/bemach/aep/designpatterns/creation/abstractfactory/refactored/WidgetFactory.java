package com.bemach.aep.designpatterns.creation.abstractfactory.refactored;

public class WidgetFactory {
	enum WindowType {
		PMWindow, MotifWindow
	};

	enum ScrollBarType {
		PMScrollBar, MotifScrollBar
	};

	public static Window createWindow(WindowType windowType) {
		switch (windowType) {
		case PMWindow:
			return PMWidgetFactory.createWindow();

		case MotifWindow:
			return MotifWidgetFactory.createWindow();
		}

		return null;
	}

	public static ScrollBar createScrollBar(ScrollBarType scrollBarType) {
		switch (scrollBarType) {
		case PMScrollBar:
			return PMWidgetFactory.createScrollBar();

		case MotifScrollBar:
			return MotifWidgetFactory.createScrollBar();
		}

		return null;
	}
}
