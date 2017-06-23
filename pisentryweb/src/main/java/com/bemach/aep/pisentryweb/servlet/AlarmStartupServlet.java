package com.bemach.aep.pisentryweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.event.EmailSender;
import com.bemach.aep.pisentry.event.EmailSenderImpl;
import com.bemach.aep.pisentry.event.EventProcessorImpl;
import com.bemach.aep.pisentry.event.UdpEventReceiver;
import com.bemach.aep.pisentry.event.UdpReceiverImpl;
import com.bemach.aep.pisentry.state.NotificationManagerImpl;
import com.bemach.aep.pisentry.state.StateManagerImpl;
import com.bemach.aep.pisentry.zone.ZoneManagerImpl;

public class AlarmStartupServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(AlarmStartupServlet.class);
	private Thread receiver = null;

	public void init() throws ServletException {
		BasicConfigurator.configure();

		ReceiverThread receiverThread = new ReceiverThread();
		EventProcessorImpl eventProcessor = new EventProcessorImpl();
		UdpEventReceiver udpEventReceiver = new UdpEventReceiver();
		udpEventReceiver.setUdpReceiver(new UdpReceiverImpl(9123));
		NotificationManagerImpl notificationMgr = new NotificationManagerImpl();
		EmailSender email = new EmailSenderImpl();
		notificationMgr.setEmailSender(email);
		StateManagerImpl stateMgr = StateManagerImpl.getInstance();
		stateMgr.setNotificationManager(notificationMgr);
		ZoneManagerImpl zoneMgr = ZoneManagerImpl.getInstance();

		eventProcessor.setStateMgr(stateMgr);
		eventProcessor.setZoneMgr(zoneMgr);
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
