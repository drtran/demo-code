package com.drkiettran.tools.speedreader;

import java.util.TimerTask;

public class TextTimerTask extends TimerTask {

	private TextPanel textPanel;

	public void register(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	@Override
	public void run() {
		textPanel.next();
		if (textPanel.isDoneReading()) {
			cancel();
		}
	}

}
