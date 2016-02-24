package com.bemach.aep.mockito;

public interface StateManager {

	public void process(Event fault);

	public State getState();
}
