package com.drkiettran.tools.speedreader;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.drkiettran.tools.speedreader.ReaderListener.Command;

public class Toolbar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1877385347441916309L;
	private JButton readButton;
	private JButton stopButton;
	private ReaderListener readerListener;
	private JButton resetButton;
	private JButton readAtButton;

	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		readButton = new JButton("Read");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		readAtButton = new JButton("Read At");

		readButton.addActionListener(this);
		stopButton.addActionListener(this);
		resetButton.addActionListener(this);
		readAtButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(readButton);
		add(readAtButton);
		add(stopButton);
		add(resetButton);
	}

	public void setReaderListener(ReaderListener readerListener) {
		this.readerListener = readerListener;
	}

	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		if (readerListener != null) {
			if (clicked == readButton) {
				readerListener.invoke(Command.START);
			} else if (clicked == stopButton) {
				readerListener.invoke(Command.STOP);
			} else if (clicked == resetButton) {
				readerListener.invoke(Command.RESET);
			} else if (clicked == readAtButton) {
				readerListener.invoke(Command.START_AT);
			}
		}
	}
}
