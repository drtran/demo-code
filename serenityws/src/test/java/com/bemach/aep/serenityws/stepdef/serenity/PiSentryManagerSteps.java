package com.bemach.aep.serenityws.stepdef.serenity;

import com.bemach.aep.pisentry.vos.State;
import com.bemach.aep.serenityws.restful.SystemState;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import net.thucydides.core.annotations.Step;

public class PiSentryManagerSteps {

	@Step
	public Boolean i_verify_PI_Sentry_is_running() {
		return isPiSentryRunning();
	}

	@Step
	public void i_disarm_the_system() {
		disarm();
		waitFor(5); // wait for email to complete
	}

	@Step
	public void i_arm_away_the_system() {
		arm_away();
		waitFor(5); // wait for email to complete
	}

	@Step
	public boolean i_verify_PI_Sentry_is_armed_away() {
		return isArmedAway();
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean isDisarmed() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/pisentryweb/services/alarmManager/getState");
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);
		SystemState ss = response.getEntity(SystemState.class);
		return ss.getState() == State.UNARMED;
	}

	private boolean isArmedAway() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/pisentryweb/services/alarmManager/getState");
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);
		SystemState ss = response.getEntity(SystemState.class);
		return ss.getState() == State.ARMED_AWAY;
	}

	private boolean arm_away() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/pisentryweb/services/alarmManager/arm_away");
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.put(ClientResponse.class);
		return response.getStatus() == 204;
	}

	private boolean disarm() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/pisentryweb/services/alarmManager/disarm");
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.put(ClientResponse.class);
		return response.getStatus() == 204;
	}

	private boolean isPiSentryRunning() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/pisentryweb/services/alarmManager/getState");
		ClientResponse response = webResource.accept("application/json").type("application/json")
				.get(ClientResponse.class);
		return response.getStatus() == 200;
	}

}
