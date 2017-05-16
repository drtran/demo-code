package com.drkiettran.tools.speedreader;

import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame mainFrame = new MainFrame();
			}
		});
	}
}
