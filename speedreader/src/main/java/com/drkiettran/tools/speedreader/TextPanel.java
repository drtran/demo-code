package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = -825536523977292110L;
	private JTextArea textArea;
	private JLabel displayLabel;
	private int index = 0;
	private String readingText = null;
	private String[] readingWordList;
	private boolean doneReading;
	private String lastWord;
	private JLabel infoLabel;
	private int skippingWords;

	public TextPanel() {
		displayLabel = new JLabel("");
		displayLabel.setFont(new Font("Candara", Font.PLAIN, 60));
		textArea = new JTextArea();
		textArea.setFont(new Font("Candara", Font.PLAIN, 18));
		infoLabel = new JLabel("");

		Border innerBorder = BorderFactory.createTitledBorder("Reading");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		setLayout(new BorderLayout());
		add(displayLabel, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(infoLabel, BorderLayout.SOUTH);

	}

	public void reset() {
		readingText = null;
		index = 0;
		textArea.setText("");
		displayLabel.setText("");
		infoLabel.setText("");
		repaint();
	}

	public void next() {
		if (skippingWords-- > 0) {
			return;
		}

		if (readingText == null) {
			readingText = spacingText(textArea.getText());
			index = 0;

			StringTokenizer st = new StringTokenizer(readingText, " ");
			readingWordList = new String[st.countTokens()];

			while (st.hasMoreTokens()) {
				readingWordList[index++] = st.nextToken();
			}

			index = 0;
		}

		if (index < readingWordList.length) {
			lastWord = readingWordList[index++];

			char c = lastWord.charAt(lastWord.length() - 1);
			switch (c) {
			case ',':
				skippingWords = 1;
				break;

			case ';':
			case '!':
			case '.':
				skippingWords = 2;
				break;
			}
			displayLabel.setText(lastWord);
			infoLabel.setText(String.format("%d of %d words (%d%%)", index, readingWordList.length,
					(100 * index) / readingWordList.length));
			repaint();
		}
	}

	private String spacingText(String text) {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(c);
			if (c == '.' || c == ',' || c == ';' || c == '!') {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

}
