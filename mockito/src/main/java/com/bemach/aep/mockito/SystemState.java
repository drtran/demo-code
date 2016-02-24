package com.bemach.aep.mockito;

import java.io.Serializable;

public class SystemState implements Serializable {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public SystemState(State state) {
		this.state = state;
	}
}
