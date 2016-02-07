package com.bemach.aep.pisentryweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

import com.bemach.aep.pisentry.event.EventProcessorImpl;
import com.bemach.aep.pisentry.event.UdpEventReceiver;
import com.bemach.aep.pisentry.event.UdpReceiverImpl;
import com.bemach.aep.pisentry.state.NotificationManagerImpl;
import com.bemach.aep.pisentry.state.StateManagerImpl;
import com.bemach.aep.pisentry.zone.ZoneManagerImpl;

public class AlarmStartupServlet extends HttpServlet {
	private Thread receiver = null;

	public void init() throws ServletException {
		BasicConfigurator.configure();
		ReceiverThread receiverThread = new ReceiverThread();
		EventProcessorImpl eventProcessor = new EventProcessorImpl();
		UdpEventReceiver udpEventReceiver = new UdpEventReceiver();
		udpEventReceiver.setUdpReceiver(new UdpReceiverImpl(9999));

		eventProcessor.setStateMgr(StateManagerImpl.getInstance());
		eventProcessor.setZoneMgr(ZoneManagerImpl.getInstance());
		eventProcessor.setNotificationMgr(NotificationManagerImpl.getInstance());
		receiverThread.setReceiver(udpEventReceiver);
		receiverThread.setEventProcessor(eventProcessor);
		receiver = new Thread(receiverThread, "MessageReceiver");
		receiver.start();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void destroy() {

	}
}
