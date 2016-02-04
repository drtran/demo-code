package com.bemach.aep.pisentryweb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.state.StateManagerImpl;

@Path("alarmManager/{name}")
public class AlarmManager extends Application {
	@GET
	@Produces("text/plain")
	public String getStatus(@PathParam("name") String name) {
		StateManager stateManager = new StateManagerImpl(null);
		return "Hello, " + name + ":" + stateManager.getState();
	}
}
