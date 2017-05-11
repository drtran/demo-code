package com.bemach.aep.designpatterns.structural.adapter;

/**
 * 
 * You can change TextView to fit Shape interface; however, it can be difficult
 * if you do not have the source code. Besides, it can be difficult to have this
 * class servers too many purposes (SRP problem).
 * 
 * An adapter is a better way to 'adapt' TextView into TextShape.
 *
 */
public class TextView {
	public String getExtent() {
		System.out.println(this.getClass().getName() + ": get extent ...");
		return "text";
	}
}
