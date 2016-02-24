package com.bemach.aep.mockito;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * This is a WRAPPER for UDP Sender/Receiver, Unit testing this is not really
 * necessary.
 * 
 * @author ktran
 *
 */
public class UdpReceiverImpl implements UdpReceiver {
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
			System.out.println("Receiving .... ");
			socket.receive(packet);
			msg = new String(packet.getData(), 0, packet.getLength());
			System.out.println("Received: '" + msg + "'");
		} catch (Exception e) {
			System.out.println("UdpReceiverImpl.receive error: " + e);
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
		return msg;
	}

}
