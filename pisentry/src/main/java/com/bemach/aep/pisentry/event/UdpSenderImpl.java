package com.bemach.aep.pisentry.event;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.enterprise.inject.Default;

@Default
public class UdpSenderImpl implements UdpSender {

	public void sendTo(String msg, String hostname, int port) {
		try {
			DatagramSocket socket = new DatagramSocket(0);
			socket.setSoTimeout(10000);
			InetAddress host = InetAddress.getByName(hostname);
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), host, 9999);
			socket.send(packet);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
