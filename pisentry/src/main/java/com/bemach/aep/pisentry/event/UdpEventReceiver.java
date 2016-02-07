package com.bemach.aep.pisentry.event;

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

	private UdpReceiver udpReceiver;

	public void setUdpReceiver(UdpReceiver udpReceiver) {
		this.udpReceiver = udpReceiver;
	}

	public Event receive() {
		return new Event(udpReceiver.receive());
	}

}
