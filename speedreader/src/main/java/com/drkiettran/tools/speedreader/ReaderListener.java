package com.drkiettran.tools.speedreader;

public interface ReaderListener {
	public enum Command {
		START, STOP, RESET, RESTART, LOAD, START_AT, SMALLER_TEXT_FONT, LARGER_TEXT_FONT, SMALLER_WORD_FONT, LARGER_WORD_FONT
	};

	void invoke(Command cmd);
}
