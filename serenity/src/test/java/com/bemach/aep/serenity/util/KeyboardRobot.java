package com.bemach.aep.serenity.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class KeyboardRobot extends Robot {

	public KeyboardRobot() throws AWTException {
		super();
	}

	public void enterEnterKey() {
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
	}

	public void enterTabKey() {
		keyPress(KeyEvent.VK_TAB);
		keyRelease(KeyEvent.VK_TAB);
	}

	public void enterTextField(String text) {
		StringSelection ssText = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssText, null);
		keyPress(KeyEvent.VK_CONTROL);
		keyPress(KeyEvent.VK_V);
		keyRelease(KeyEvent.VK_V);
		keyRelease(KeyEvent.VK_CONTROL);
	}
}
