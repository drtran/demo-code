package com.bemach.aep.pisentry.event;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.vos.Event;

/**
 * This class is wrapper type, it is not necessary to have unit tests here.
 * 
 * @author ktran
 *
 */
public class UdpEventReceiver implements EventReceiver {
	private static Logger logger = Logger.getLogger(UdpEventReceiver.class);

	public Event receive() throws IOException {
		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket(9999);
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			logger.info("Receiving .... ");
			socket.receive(packet);
			String msg = new String(packet.getData(), 0, packet.getLength());
			logger.info(msg);
			return new Event(msg);
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
