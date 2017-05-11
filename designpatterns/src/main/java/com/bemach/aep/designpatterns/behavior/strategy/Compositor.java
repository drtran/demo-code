package com.bemach.aep.designpatterns.behavior.strategy;

public abstract class Compositor {
	public enum CompositorType {
		Simple, TeX, Array
	};

	abstract void compose();

	public static Compositor makeCompositor(CompositorType type) {
		switch (type) {
		case Simple:
			return new SimpleCompositor();
		case TeX:
			return new TeXCompository();
		case Array:
			return new ArrayCompository();
		}
		return null;

	}
}
