package com.bemach.aep.designpatterns.behavior.strategy;

public class SimpleCompositor extends Compositor {

	@Override
	void compose() {
		System.out.println(this.getClass().getName() + ": composing ...");
	}

}
