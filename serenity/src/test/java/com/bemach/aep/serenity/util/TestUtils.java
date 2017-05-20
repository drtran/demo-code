package com.bemach.aep.serenity.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TestUtils {

	public static void threadWait(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// ignore.
		}
	}

	/**
	 * <code>IMPORTANT</code>
	 * 
	 * In order for this Robot code to work, the launched browser 'MUST BE' in
	 * focus. in other words, when you run this code, you 'CANNOT' be doing
	 * something else with your PC. This is because the Robot is basically
	 * taking over the keyboards. Therefore, as soon as you switch to do
	 * something else while the login code is executing, the keyboard is back to
	 * your control. The Robot code then no longer has control of the keyboard.
	 * 
	 * @param userId
	 * @param password
	 */
	public void popup_authentication_thread(String userId, String password) {

		new Thread(() -> {
			threadWait(1000);

			KeyboardRobot keyboardRobot = makeKeyboardRobot();

			keyboardRobot.enterTextField(userId);
			keyboardRobot.enterTabKey();

			threadWait(1000);

			keyboardRobot.enterTextField(password);
			keyboardRobot.enterEnterKey();

			threadWait(1000);

		}).start();

	}

	private KeyboardRobot makeKeyboardRobot() {
		try {
			return new KeyboardRobot();
		} catch (AWTException e) {
			return null;
		}
	}
}
