package com.drkiettran.tools.speedreader;

public interface ReaderListener {
	public enum Command {
		START, STOP, RESET, RESTART, LOAD, START_AT
	};

	void invoke(Command cmd);
}
