package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = -825536523977292110L;
	private final String INSTRUCTION = "Help: \n"
			+ "\nMethod 1:\n- Cut and paste text into the text box on the right.\n- Click on the Read button.\n"
			+ "\nMethod 2 (NOT IMPLEMENTED YET):\n- Enter File Name on the left.\n- Click the Load button.\n- Click on the Read button.\n"
			+ "\nSpeed:\n- Enter the speed (word per minute).\n- Click the Set button.\n"
			+ "\nPause:\n- Click the Stop button.\n" + "\nUnpause:\n- Click the Read button.\n"
			+ "\nReset:\n- Click the Reset button to clear out the text area.\n" + "\nAuthor: Kiet T. Tran, 2017.\n";

	private JTextArea textArea;
	private JLabel displayingText;
	private int currentReadingIndex = 0;
	private String readingText = null;
	private String[] readingTextInWordList;
	private JLabel infoLabel;
	private int addingWordsForDelay;
	private JLabel titleLabel;

	public TextPanel() {
		displayingText = new JLabel("");
		displayingText.setFont(new Font("Candara", Font.PLAIN, 60));
		infoLabel = new JLabel("");
		titleLabel = new JLabel("Title:");

		textArea = new JTextArea(INSTRUCTION);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		Border innerBorder = BorderFactory.createTitledBorder("Reading");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		setLayout(new BorderLayout());
		add(displayingText, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(titleLabel, BorderLayout.SOUTH);
		add(infoLabel, BorderLayout.SOUTH);

	}

	public void reset() {
		readingText = null;
		currentReadingIndex = 0;
		textArea.setText(INSTRUCTION);
		displayingText.setText("");
		infoLabel.setText("");
		repaint();
	}

	public void next() {
		if (addingWordsForDelay-- > 0) {
			return;
		}

		if (readingText == null) {
			readingText = textArea.getText();
			readingTextInWordList = new ReadingTextManager(readingText).getReadingWordList();
			currentReadingIndex = 0;
		}

		if (thereIsMoreToRead()) {
			String wordToRead = getNextWord();

			addingWordsForDelay = settingDelayInWords(wordToRead);
			displayingText.setText(wordToRead);
			displayReadingInformation();
			repaint();
		}
	}

	private int settingDelayInWords(String wordToRead) {
		switch (wordToRead.charAt(wordToRead.length() - 1)) {
		case ',':
			return 1;

		case ';':
		case '!':
		case '.':
			if (notInExcludedList(wordToRead)) {
				return 2;
			}

		}
		return 0;
	}

	private final String EXCLUDED_LIST_FOR_DELAY[] = { "mr.", "ms.", "fr.", "sr.", "jr.", "etc.", "i.e." };

	private boolean notInExcludedList(String wordToRead) {
		for (String excluded : EXCLUDED_LIST_FOR_DELAY) {
			if (excluded.equalsIgnoreCase(wordToRead)) {
				return false;
			}
		}
		return true;
	}

	private void displayReadingInformation() {
		infoLabel.setText(String.format("%d of %d words (%d%%)", currentReadingIndex, readingTextInWordList.length,
				(100 * currentReadingIndex) / readingTextInWordList.length));
	}

	private String getNextWord() {
		return readingTextInWordList[currentReadingIndex++];
	}

	private boolean thereIsMoreToRead() {
		return currentReadingIndex < readingTextInWordList.length;
	}
}
