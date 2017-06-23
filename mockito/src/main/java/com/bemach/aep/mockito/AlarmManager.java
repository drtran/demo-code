package com.bemach.aep.mockito;

public class AlarmManager {
	private static final String LOCALHOST = "localhost";
	private static final String DATA_NOOP = "NOOP";
	private StateManager stateManager = StateManagerImpl.getInstance();
	private UdpEventSender eventSender = null;

	public SystemState getStatus() {
		return new SystemState(stateManager.getState());
	}

	public void armAway() {
		sendEvent(EventType.ARM_AWAY, DATA_NOOP);
	}

	public void armHome() {
		sendEvent(EventType.ARM_HOME, DATA_NOOP);
	}

	public void disarm() {
		sendEvent(EventType.DISARM, DATA_NOOP);
	}

	/**
	 * Place an event in Queue.
	 * 
	 * @param type
	 * @param data
	 */
	private void sendEvent(EventType type, String data) {
		UdpEventSender eventSender = getUdpEventSender();
		Event event = new Event(AlarmManager.class.toString(), type, data);
		eventSender.setUdpSender(new UdpSenderImpl(LOCALHOST, 9123));
		eventSender.send(event);
	}

	public UdpEventSender getUdpEventSender() {
		if (eventSender == null) {
			eventSender = new UdpEventSender();
		}
		return eventSender;
	}

	public void setEventSender(UdpEventSender eventSender) {
		this.eventSender = eventSender;
	}
}
