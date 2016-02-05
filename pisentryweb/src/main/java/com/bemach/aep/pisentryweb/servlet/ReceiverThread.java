package com.bemach.aep.pisentryweb.servlet;

import java.io.IOException;
import java.net.SocketException;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.event.EventProcessor;
import com.bemach.aep.pisentry.event.EventReceiver;
import com.bemach.aep.pisentry.state.StateManagerImpl;
import com.bemach.aep.pisentry.vos.Event;

public class ReceiverThread implements Runnable {
	private static Logger logger = Logger.getLogger(ReceiverThread.class);

	private EventProcessor eventProcessor;
	private EventReceiver receiver;

	public void run() {
		String previousAlarmMsg = "";
		logger.info("Starting up ...");
		for (;;) {
			try {
				Event event = receiver.receive();
				eventProcessor.process(event);
				logger.info("Received: " + event);
				logger.info("State Manager: " + StateManagerImpl.getInstance().getState());
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setEventProcessor(EventProcessor eventProcessor) {
		this.eventProcessor = eventProcessor;
	}

	public void setReceiver(EventReceiver receiver) {
		this.receiver = receiver;
	}

}
