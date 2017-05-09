package com.bemach.aep.solid.lsp.refactored;

public class Square extends Quadrilaterals {
	public void setWidthAndHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
}
