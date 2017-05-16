package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5184507871687024902L;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private TextTimerTask textTimerTask = null;
	private Timer timer = null;

	public MainFrame() {
		super("Simple Speed Reader Program");

		setLayout(new BorderLayout());
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();

		ReaderListener readerListener = new ReaderListener() {
			public void invoke(Command cmd) {
				switch (cmd) {
				case START:
					if (textTimerTask == null) {
						textTimerTask = new TextTimerTask();
						textTimerTask.register(textPanel);
						timer = new Timer();
						int speedWpm = formPanel.getSpeedWpm();
						timer.schedule(textTimerTask, 0, (60 * 1000) / speedWpm);
					}
					break;

				case RESET:
					textPanel.reset();
					// let it fall ...
				case STOP:
					if (textTimerTask != null) {
						timer.cancel();
						textTimerTask = null;
						timer = null;
					}
					break;

				default:
					break;
				}
			}
		};
		toolbar.setReaderListener(readerListener);

		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
