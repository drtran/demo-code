package com.drkiettran.tools.speedreader;

import java.util.StringTokenizer;

public class ReadingTextManager {

	private String readingText;

	public ReadingTextManager(String readingText) {
		this.readingText = spacingText(readingText);
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
		for (char c : text.toCharArray()) {
			sb.append(c);
			if (isSeparator(c)) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	private static final char[] SEPARATORS = new char[] { '?', '.', ',', ';', '!', '\n', '\r' };

	private boolean isSeparator(char c) {
		for (char separator : SEPARATORS) {
			if (c == separator) {
				return true;
			}
		}
		return false;
	}
}
