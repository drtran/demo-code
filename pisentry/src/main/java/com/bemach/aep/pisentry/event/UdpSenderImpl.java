package com.bemach.aep.pisentry.event;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

/**
 * This is a WRAPPER for UDP Sender/Receiver, Unit testing this is not really
 * necessary.
 * 
 * @author ktran
 *
 */
public class UdpSenderImpl implements UdpSender {
	private static Logger logger = Logger.getLogger(UdpSenderImpl.class);
	private String hostname;
	private int port;

	public UdpSenderImpl(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void sendTo(String msg) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket(0);
			socket.setSoTimeout(10000);
			InetAddress host = InetAddress.getByName(hostname);
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), host, port);
			socket.send(packet);
		} catch (Exception e) {
			logger.error("UdpSender.send exception: " + e);
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
