package com.bemach.aep.designpatterns.behavior.strategy;

public class ArrayCompository extends Compositor {

	@Override
	void compose() {
		System.out.println(this.getClass().getName() + ": composing ...");
	}

}
