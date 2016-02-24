package com.bemach.aep.mockito;

/**
 * This class is wrapper type, it is not necessary to have unit tests here.
 * 
 * @author ktran
 *
 */
public class UdpEventReceiver implements EventReceiver {

	private UdpReceiver udpReceiver;

	public void setUdpReceiver(UdpReceiver udpReceiver) {
		this.udpReceiver = udpReceiver;
	}

	public Event receive() {
		return new Event(udpReceiver.receive());
	}

}
