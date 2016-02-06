package com.bemach.aep.pisentryweb.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.bemach.aep.pisentry.vos.State;

@XmlRootElement(name = "systemState")
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
