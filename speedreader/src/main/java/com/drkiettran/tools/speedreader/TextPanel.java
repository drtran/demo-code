package com.drkiettran.tools.speedreader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;

import com.drkiettran.tika.text.ReadingTextManager;
import com.drkiettran.tika.text.TextApp;
import com.drkiettran.tools.speedreader.ReaderListener.Command;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = -825536523977292110L;
	private String helpText = loadHelpText();
	private JTextArea textArea;
	private JLabel displayingText;
	private String readingText = null;
	private JLabel infoLabel;
	private int addingWordsForDelay;
	private JLabel titleLabel;
	private final String EXCLUDED_LIST_FOR_DELAY[] = { "mr.", "ms.", "fr.", "sr.", "jr.", "etc.", "i.e." };
	private ReaderListener readerListener;
	private ReadingTextManager readingTextManager;

	private String displayingFontName = "Candara";
	private int displayingFontSize = 60;
	private String textAreaFontName = "Times New Roman";
	private int textAreaFontSize = 18;
	private int defaultBlinkRate = 0;
	private boolean doneReading = false;

	public boolean isDoneReading() {
		return doneReading;
	}

	public TextPanel() {
		arrangeFixedComponents();
		makeTextArea();
		setBorder();
		arrangeLayout();
	}

	private void arrangeFixedComponents() {
		displayingText = new JLabel("");
		displayingText.setFont(new Font(displayingFontName, Font.PLAIN, displayingFontSize));
		infoLabel = new JLabel("");
		titleLabel = new JLabel("Title:");
	}

	private void arrangeLayout() {
		setLayout(new BorderLayout());
		add(displayingText, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(titleLabel, BorderLayout.SOUTH);
		add(infoLabel, BorderLayout.SOUTH);
	}

	private void setBorder() {
		Border innerBorder = BorderFactory.createTitledBorder("Reading");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));
	}

	private void makeTextArea() {
		textArea = new JTextArea(helpText);
		defaultBlinkRate = textArea.getCaret().getBlinkRate();
		textArea.setCaretPosition(0);
		textArea.setCaret(new FancyCaret());
		textArea.setCaretColor(Color.red);
		textArea.setFont(new Font(textAreaFontName, Font.PLAIN, textAreaFontSize));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				readerListener.invoke(Command.RESTART);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				readerListener.invoke(Command.RESTART);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				readerListener.invoke(Command.RESTART);
			}

		});
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	private void restart() {
		readingTextManager = new ReadingTextManager(helpText);
	}

	public void resetReading() {
		restart();
		readingText = null;
		textArea.setText(helpText);
		textArea.setCaret(new DefaultCaret());
		textArea.setCaretPosition(0);
		textArea.requestFocus();
		displayingText.setText("");
		infoLabel.setText("");
		repaint();
	}

	public void next() {

		if (addingWordsForDelay-- > 0) {
			return;
		}

		if (readingText == null) {
			doneReading = false;
			readingText = textArea.getText();
			textArea.setText(readingText);
			readingTextManager = new ReadingTextManager(readingText);
			textArea.setText(readingTextManager.getReadingText());
		}

		String wordToRead = getNextWord();

		if (wordToRead != null) {
			addingWordsForDelay = settingDelayInWords(wordToRead);
			textArea.setCaretPosition(readingTextManager.getCurrentCaret());
			textArea.requestFocus();
			displayingText.setText(wordToRead);
			displayReadingInformation();
		} else {
			displayReadingInformation();
			doneReading = true;
		}
		repaint();
	}

	private int settingDelayInWords(String wordToRead) {
		if (wordToRead.isEmpty()) {
			return 0;
		}

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

	private boolean notInExcludedList(String wordToRead) {
		for (String excluded : EXCLUDED_LIST_FOR_DELAY) {
			if (excluded.equalsIgnoreCase(wordToRead)) {
				return false;
			}
		}
		return true;
	}

	private void displayReadingInformation() {
		int wordsFromBeginning = readingTextManager.getWordsFromBeginning();
		int totalWords = readingTextManager.getTotalWords();
		int readingPercentage = (100 * wordsFromBeginning) / totalWords;

		infoLabel.setText(String.format("%d of %d words (%d%%)", wordsFromBeginning, totalWords, readingPercentage));
		infoLabel.setForeground(Color.BLUE);
	}

	private String getNextWord() {
		return readingTextManager.getNextWord();
	}

	public void setReaderListener(ReaderListener readerListener) {
		this.readerListener = readerListener;
	}

	public void loadTextFromFile(String text) {
		restart();
		readingText = null;
		textArea.setText(text);

		displayingText.setText("");
		infoLabel.setText("");
		repaint();
	}

	private String loadHelpText() {
		try (InputStream is = TextApp.class.getResourceAsStream("/Helpfile.txt")) {
			StringBuilder sb = new StringBuilder();

			for (;;) {
				int c = is.read();
				if (c < 0) {
					break;
				}
				sb.append((char) c);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void stopReading() {
		textArea.setCaret(new DefaultCaret());
		textArea.getCaret().setBlinkRate(defaultBlinkRate);
		textArea.setCaretPosition(readingTextManager.getCurrentCaret());
		textArea.requestFocus();
	}

	public void startReading() {
		textArea.setCaret(new FancyCaret());
		if (readingTextManager != null) {
			textArea.setCaretPosition(readingTextManager.getCurrentCaret());
		} else {
			textArea.setCaretPosition(0);
		}
		textArea.requestFocus();
	}

	public void setCurrentCaretAt() {
		if (readingTextManager != null) {
			readingTextManager.setCurrentCaret(textArea.getCaretPosition());
		}
	}
}
