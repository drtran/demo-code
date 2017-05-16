package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
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
			+ "\nMethod 2 (NOT IMPLEMENTED YET):\n- Enter File Name on the left.\n- Click the Load button.\n- Click on the Read button."
			+ "\nSpeed:\n- Enter the speed (word per minute).\n- Click the Set button.\n"
			+ "\nPause:\n- Click the Stop button.\n" + "\nUnpause:\n- Click the Read button.\n"
			+ "\nReset:\n- Click the Reset button to clear out the text area.\n";

	private JTextArea textArea;
	private JLabel displayingText;
	private int currentReadingIndex = 0;
	private String readingText = null;
	private String[] readingTextInWordList;
	private boolean doneReading;
	private String lastWord;
	private JLabel infoLabel;
	private int addingWordsForDelay;

	public TextPanel() {
		displayingText = new JLabel("");
		displayingText.setFont(new Font("Candara", Font.PLAIN, 60));
		infoLabel = new JLabel("");

		textArea = new JTextArea(INSTRUCTION);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		Border innerBorder = BorderFactory.createTitledBorder("Reading");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		setLayout(new BorderLayout());
		add(displayingText, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(infoLabel, BorderLayout.SOUTH);

	}

	public void reset() {
		readingText = null;
		currentReadingIndex = 0;
		textArea.setText("");
		displayingText.setText("");
		infoLabel.setText("");
		repaint();
	}

	public void next() {
		if (addingWordsForDelay-- > 0) {
			return;
		}

		if (readingText == null) {
			readingText = spacingText(textArea.getText());
			currentReadingIndex = 0;

			StringTokenizer st = new StringTokenizer(readingText, " ");
			readingTextInWordList = new String[st.countTokens()];

			while (st.hasMoreTokens()) {
				readingTextInWordList[currentReadingIndex++] = st.nextToken();
			}

			currentReadingIndex = 0;
		}

		if (currentReadingIndex < readingTextInWordList.length) {
			lastWord = readingTextInWordList[currentReadingIndex++];

			char c = lastWord.charAt(lastWord.length() - 1);
			switch (c) {
			case ',':
				addingWordsForDelay = 1;
				break;

			case ';':
			case '!':
			case '.':
				addingWordsForDelay = 2;
				break;
			}
			System.out.println(lastWord);
			displayingText.setText(lastWord);
			infoLabel.setText(String.format("%d of %d words (%d%%)", currentReadingIndex, readingTextInWordList.length,
					(100 * currentReadingIndex) / readingTextInWordList.length));
			repaint();
		}
	}

	private String spacingText(String text) {

		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(c);
			if (isSeparator(c)) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	private static final char[] SEPARATORS = new char[] { '.', ',', ';', '!', '\n', '\r' };

	private boolean isSeparator(char c) {
		for (char separator : SEPARATORS) {
			if (c == separator) {
				return true;
			}
		}
		return false;
	}

}
