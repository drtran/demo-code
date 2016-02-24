package com.bemach.aep.pisentryweb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.event.UdpEventSender;
import com.bemach.aep.pisentry.event.UdpSenderImpl;
import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.state.StateManagerImpl;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

@Path("/alarmManager")
public class AlarmManager extends Application {
	private static final String LOCALHOST = "localhost";
	private static final String DATA_NOOP = "NOOP";
	private static Logger logger = Logger.getLogger(AlarmManager.class);
	private StateManager stateManager = StateManagerImpl.getInstance();
	private UdpEventSender eventSender = null;

	@GET
	@Path("/getState")
	@Produces(MediaType.APPLICATION_JSON)
	public SystemState getStatus() {
		logger.info("getting state.");
		logger.info("Alarm state: " + stateManager.getState());
		return new SystemState(stateManager.getState());
	}

	@PUT
	@Path("/arm_away")
	@Produces(MediaType.APPLICATION_JSON)
	public void armAway() {
		logger.info("arming away.");
		sendEvent(EventType.ARM_AWAY, DATA_NOOP);
	}

	@PUT
	@Path("/arm_home")
	@Produces(MediaType.APPLICATION_JSON)
	public void armHome() {
		logger.info("arming home.");
		sendEvent(EventType.ARM_HOME, DATA_NOOP);
	}

	@PUT
	@Path("/disarm")
	@Produces(MediaType.APPLICATION_JSON)
	public void disarm() {
		logger.info("disarming.");
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
		eventSender.setUdpSender(new UdpSenderImpl(LOCALHOST, 9999));
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
