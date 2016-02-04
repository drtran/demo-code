package com.bemach.aep.pisentryweb.servlet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.apache.log4j.Logger;

public class ReceiverThread implements Runnable {
	private static Logger logger = Logger.getLogger(ReceiverThread.class);

	public void run() {

		DatagramSocket datagramSocket = null;

		try {
			datagramSocket = new DatagramSocket(9999);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}

		String previousAlarmMsg = "";

		for (;;) {

			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			logger.info("Receiving .... ");
			try {
				datagramSocket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String alarmMsg = new String(packet.getData(), 0, packet.getLength());
			if (alarmMsg.equals(previousAlarmMsg)) {
				logger.info("");
				continue;
			}
			logger.info(alarmMsg);
			previousAlarmMsg = alarmMsg;
		}
	}

}
