package com.bemach.aep.pisentryweb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.event.UdpEventSender;
import com.bemach.aep.pisentry.event.UdpSenderImpl;
import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.state.StateManagerImpl;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

@Path("/alarmManager")
public class AlarmManager2BRefactored extends Application {
	private static final String LOCALHOST = "localhost";
	private static final String DATA_NOOP = "NOOP";
	private static Logger logger = Logger.getLogger(AlarmManager2BRefactoredTest.class);
	private StateManager stateManager = StateManagerImpl.getInstance();
	private UdpEventSender eventSender = null;

	// curl -X GET
	// http://localhost:8080/pisentryweb/services/alarmManager/getState
	@GET
	@Path("/getState")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatus() {
		logger.info("getting state.");
		logger.info("Alarm state: " + stateManager.getState());
		SystemState ss = new SystemState(stateManager.getState());
		// return new SystemState(stateManager.getState());
		return Response.ok(ss, MediaType.APPLICATION_JSON).build();
	}

	// curl -X PUT
	// http://localhost:8080/pisentryweb/services/alarmManager/arm_away
	@PUT
	@Path("/arm_away")
	@Produces(MediaType.APPLICATION_JSON)
	public void armAway() {
		logger.info("arming away.");
		sendEvent(EventType.ARM_AWAY, DATA_NOOP);
	}

	private void sendEvent(EventType eventType, String eventData) {
		UdpEventSender eventSender = getUdpEventSender();
		Event event = new Event(AlarmManager2BRefactoredTest.class.toString(), eventType, eventData);
		eventSender.setUdpSender(new UdpSenderImpl(LOCALHOST, 9999));
		eventSender.send(event);
	}

	// curl -X PUT
	// http://localhost:8080/pisentryweb/services/alarmManager/arm_home
	@PUT
	@Path("/arm_home")
	@Produces(MediaType.APPLICATION_JSON)
	public void armHome() {
		logger.info("arming home.");
		sendEvent(EventType.ARM_HOME, DATA_NOOP);
	}

	// curl -X PUT
	// http://localhost:8080/pisentryweb/services/alarmManager/disarm
	@PUT
	@Path("/disarm")
	@Produces(MediaType.APPLICATION_JSON)
	public void disarm() {
		logger.info("disarming.");
		sendEvent(EventType.DISARM, DATA_NOOP);
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
