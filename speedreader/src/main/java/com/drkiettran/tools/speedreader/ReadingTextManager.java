package com.drkiettran.tools.speedreader;

import java.util.StringTokenizer;

public class ReadingTextManager {

	private String readingText;
	private int currentCaret;

	public ReadingTextManager(String readingText) {
		this.readingText = spacingText(readingText);
		currentCaret = 0;
	}

	public int getCurrentCaret() {
		return currentCaret;
	}

	public String getReadingText() {
		return readingText;
	}

	public String[] getReadingWordList() {
		int index = 0;

		StringTokenizer st = new StringTokenizer(readingText, " ");
		String[] readingTextInWordList = new String[st.countTokens()];

		while (st.hasMoreTokens()) {
			readingTextInWordList[index++] = st.nextToken();
		}

		return readingTextInWordList;
	}

	private String spacingText(String text) {

		StringBuilder sb = new StringBuilder();
		char[] charsInText = text.toCharArray();

		for (int i = 0; i < charsInText.length; i++) {
			sb.append(charsInText[i]);
			if (textNeedsASpace(charsInText, i)) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	private boolean textNeedsASpace(char[] charsInText, int i) {
		return isSeparator(charsInText[i]) && isNotAtTheLastChar(charsInText, i) && charsInText[i + 1] != ' ';
	}

	private boolean isNotAtTheLastChar(char[] charsInText, int i) {
		return i < charsInText.length - 1;
	}

	private static final char[] SEPARATORS = new char[] { '?', '.', ',', ';', '!', '-', '_', '/', '\n', '\r' };

	private boolean isSeparator(char c) {
		for (char separator : SEPARATORS) {
			if (c == separator) {
				return true;
			}
		}
		return false;
	}

	public String getNextWord() {
		if (currentCaret >= readingText.length()) {
			return null;
		}
		moveCaretToNextSpace();
		moveCaretToNextNonSpace();
		return extractNextWord();

	}

	private String extractNextWord() {
		int saveCurrentCaret = currentCaret;
		moveCaretToNextSpace();
		int newCurrentCaret = currentCaret;
		currentCaret = saveCurrentCaret;
		return readingText.substring(currentCaret, newCurrentCaret);
	}

	private void moveCaretToNextNonSpace() {
		while (currentCaret < readingText.length()) {
			if (readingText.charAt(currentCaret) != ' ') {
				break;
			}
			currentCaret++;
		}
	}

	private void moveCaretToNextSpace() {
		while (currentCaret < readingText.length()) {
			if (readingText.charAt(currentCaret) == ' ') {
				break;
			}
			currentCaret++;
		}
	}
}
