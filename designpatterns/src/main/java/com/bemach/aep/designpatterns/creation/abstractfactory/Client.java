package com.bemach.aep.designpatterns.creation.abstractfactory;

public class Client {
	public static void main(String... args) {
		Window pmWindow = new PMWindow();
		Window motifWindow = new MotifWindow();
		ScrollBar pmScrollBar = new PMScrollBar();
		ScrollBar motifScrollBar = new MotifScrollBar();
	}
}
