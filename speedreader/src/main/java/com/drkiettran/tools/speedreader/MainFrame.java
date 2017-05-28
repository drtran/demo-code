package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;

import javax.swing.JFrame;

import com.drkiettran.tika.text.TextApp;
import com.drkiettran.tools.speedreader.ReaderListener.Command;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5184507871687024902L;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private TextTimerTask textTimerTask = null;
	private Timer timer = null;

	public MainFrame() throws IOException {
		super("Simple Speed Reader Program");

		setLayout(new BorderLayout());
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();

		formPanel.setReaderListener((Command cmd) -> {
			switch (cmd) {
			case LOAD:
				textPanel.loadTextFromFile(formPanel.getText());
				break;
			}
		});

		textPanel.setReaderListener((Command cmd) -> {
			switch (cmd) {
			case RESET:
				textPanel.resetReading();
				break;
			default:
				break;
			}
		});

		toolbar.setReaderListener((Command cmd) -> {
			switch (cmd) {
			case START:
				if (textTimerTask == null) {
					textTimerTask = new TextTimerTask();
					textTimerTask.register(textPanel);
					timer = new Timer();
					int speedWpm = formPanel.getSpeedWpm();
					timer.schedule(textTimerTask, 0, (60 * 1000) / speedWpm);
					textPanel.startReading();
				}
				break;

			case RESET:
				textPanel.resetReading();
				// let it fall ...
			case STOP:
				if (textTimerTask != null) {
					timer.cancel();
					textTimerTask = null;
					timer = null;
					textPanel.stopReading();
				}
				break;

			default:
				break;
			}
		});

		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
