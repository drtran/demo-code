package com.bemach.aep.pisentry.event;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.bemach.aep.pisentry.utils.TestUtis;

@Alternative @Default
public class MockUdpReceiver implements UdpReceiver {

	public String receive() {
		return (String) TestUtis.get("MOCKUDPRECEIVER");
	}

}
