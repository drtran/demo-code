package com.bemach.aep.pisentry.event;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.bemach.aep.pisentry.vos.Event;

@Alternative @Default
public class MockEventReceiver implements EventReceiver {

	public Event receive() {
		// TODO Auto-generated method stub
		return null;
	}

}
