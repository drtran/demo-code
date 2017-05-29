package com.drkiettran.tools.speedreader;

public interface ReaderListener {
	public enum Command {
		START, STOP, RESET, RESTART, LOAD, START_AT, SMALLER_FONT, LARGER_FONT
	};

	void invoke(Command cmd);
}
