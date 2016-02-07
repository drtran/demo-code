package com.bemach.aep.pisentry.event;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.apache.log4j.Logger;

/**
 * This is a WRAPPER for UDP Sender/Receiver, Unit testing this is not really
 * necessary.
 * 
 * @author ktran
 *
 */
public class UdpReceiverImpl implements UdpReceiver {
	private static Logger logger = Logger.getLogger(UdpReceiverImpl.class);
	private int port;

	public UdpReceiverImpl(int port) {
		this.port = port;
	}

	public String receive() {
		DatagramSocket socket = null;

		String msg = null;
		try {
			socket = new DatagramSocket(port);
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			logger.info("Receiving .... ");
			socket.receive(packet);
			msg = new String(packet.getData(), 0, packet.getLength());
			logger.info("Received: '" + msg + "'");
		} catch (Exception e) {
			logger.error("UdpReceiverImpl.receive error: " + e);
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
		return msg;
	}

}
