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

	private boolean doneLogin = false;

	public void popup_authentication_thread(String userId, String password) {

		Thread thread = new Thread(() -> {
			TestUtils.threadWait(1000);

			try {
				Robot robot = new Robot();
				StringSelection ssId = new StringSelection(userId);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssId, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// tab to password entry field
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				TestUtils.threadWait(1000);

				// Enter password by ctrl-v
				StringSelection ssPassword = new StringSelection(password);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssPassword, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// press enter
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				TestUtils.threadWait(1000);

			} catch (AWTException e) {
				System.out.println("ERROR: " + e);
			}
			doneLogin = true;
		});

		thread.start();

	}

	public void wait_for_popup_login_to_complete() {
		while (true) {
			threadWait(5);
			if (doneLogin) {
				break;
			}
		}

	}
}
