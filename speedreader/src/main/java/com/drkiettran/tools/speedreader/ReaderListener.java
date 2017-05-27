package com.drkiettran.tools.speedreader;

public interface ReaderListener {
	public enum Command {
		START, STOP, RESET, RESTART, LOAD
	};

	void invoke(Command cmd);
}
