package com.drkiettran.tools.speedreader;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JButton largerTextFontButton;
	private JButton smallerTextFontButton;
	private JButton largerWordFontButton;
	private JButton smallerWordFontButton;

	private ImageIcon createIcon(String path) {
		URL url = getClass().getResource(path);

		if (url == null) {
			System.err.println("Unable to load image: " + path);
		}
		return new ImageIcon(url);
	}

	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		readButton = new JButton();
		readButton.setIcon(createIcon("/icons/Play16.gif"));
		readButton.setToolTipText("Read");

		stopButton = new JButton();
		stopButton.setIcon(createIcon("/icons/Pause16.gif"));
		stopButton.setToolTipText("Stop");

		resetButton = new JButton();
		resetButton.setIcon(createIcon("/icons/Stop16.gif"));
		resetButton.setToolTipText("Reset");

		readAtButton = new JButton();
		readAtButton.setIcon(createIcon("/icons/StepForward16.gif"));
		readAtButton.setToolTipText("Read At");

		largerTextFontButton = new JButton();
		largerTextFontButton.setIcon(createIcon("/icons/Up16.gif"));
		largerTextFontButton.setToolTipText("Larger text size");

		smallerTextFontButton = new JButton();
		smallerTextFontButton.setIcon(createIcon("/icons/Down16.gif"));
		smallerTextFontButton.setToolTipText("Smaller text size");

		largerWordFontButton = new JButton();
		largerWordFontButton.setIcon(createIcon("/icons/ZoomIn16.gif"));
		largerWordFontButton.setToolTipText("Larger displaying word size");

		smallerWordFontButton = new JButton();
		smallerWordFontButton.setIcon(createIcon("/icons/ZoomOut16.gif"));
		smallerWordFontButton.setToolTipText("Smaller display word size");

		readButton.addActionListener(this);
		stopButton.addActionListener(this);
		resetButton.addActionListener(this);
		readAtButton.addActionListener(this);
		largerTextFontButton.addActionListener(this);
		smallerTextFontButton.addActionListener(this);
		largerWordFontButton.addActionListener(this);
		smallerWordFontButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(readButton);
		add(readAtButton);
		add(stopButton);
		add(resetButton);
		add(largerTextFontButton);
		add(smallerTextFontButton);
		add(largerWordFontButton);
		add(smallerWordFontButton);
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
			} else if (clicked == largerTextFontButton) {
				readerListener.invoke(Command.LARGER_TEXT_FONT);
			} else if (clicked == smallerTextFontButton) {
				readerListener.invoke(Command.SMALLER_TEXT_FONT);
			} else if (clicked == largerWordFontButton) {
				readerListener.invoke(Command.LARGER_WORD_FONT);
			} else if (clicked == smallerWordFontButton) {
				readerListener.invoke(Command.SMALLER_WORD_FONT);
			}
		}
	}
}
