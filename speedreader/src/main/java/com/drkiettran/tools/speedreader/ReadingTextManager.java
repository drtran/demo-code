package com.drkiettran.tools.speedreader;

public class ReadingTextManager {

	private String readingText;
	private int currentCaret = 0;
	private int wordsFromBeginning = 0;
	private int totalWords = 0;

	public int getWordsFromBeginning() {
		return wordsFromBeginning;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public ReadingTextManager(String readingText) {
		this.readingText = spacingText(readingText);
		countTotalWords();
		currentCaret = 0;
		wordsFromBeginning = 0;
	}

	private void countTotalWords() {
		while (getNextWord() != null) {
			totalWords++;
		}
	}

	public int getCurrentCaret() {
		return currentCaret;
	}

	public String getReadingText() {
		return readingText;
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
		wordsFromBeginning++;
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

	public void setCurrentCaret(int newCaretPosition) {
		wordsFromBeginning = 0;
		currentCaret = 0;

		while (getNextWord() != null) {
			if (newCaretPosition <= currentCaret) {
				break;
			}
		}
	}

}
