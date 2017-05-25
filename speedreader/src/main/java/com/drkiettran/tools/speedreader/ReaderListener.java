package com.drkiettran.tools.speedreader;

public interface ReaderListener {
	public enum Command {
		START, STOP, RESET, RESTART
	};

	void invoke(Command cmd);
}
