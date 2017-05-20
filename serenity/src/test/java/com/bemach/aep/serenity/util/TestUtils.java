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

		Thread thread = new Thread(() -> {
			threadWait(1000);

			try {
				Robot robot = new Robot();

				enterTextField(userId, robot);
				enterTabKey(robot);

				threadWait(1000);

				enterTextField(password, robot);
				enterEnterKey(robot);

				threadWait(1000);

			} catch (AWTException e) {
				System.out.println("ERROR: " + e);
			}
		});

		thread.start();

	}

	private void enterEnterKey(Robot robot) {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	private void enterTabKey(Robot robot) {
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	private void enterTextField(String userId, Robot robot) {
		StringSelection ssId = new StringSelection(userId);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssId, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

}
