package com.bemach.aep.pisentryweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

public class AlarmStartupServlet extends HttpServlet {
	private static final long serialVersionUID = 4512758480429491137L;
	private Thread receiverThread = null;

	public void init() throws ServletException {
		BasicConfigurator.configure();
		receiverThread = new Thread(new ReceiverThread(), "MessageReceiver");
		receiverThread.start();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void destroy() {

	}
}
