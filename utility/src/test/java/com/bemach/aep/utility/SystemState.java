package com.bemach.aep.utility;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.bemach.aep.pisentry.vos.State;

@XmlRootElement
public class SystemState implements Serializable {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public SystemState() {
	}

	public SystemState(State state) {
		this.state = state;
	}
}
