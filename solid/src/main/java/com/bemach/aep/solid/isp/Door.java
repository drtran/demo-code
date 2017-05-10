package com.bemach.aep.solid.isp;

/**
 * Door becomes a 'fat' interface once it extends TimerClient.
 *  
 *
 */
public interface Door extends TimerClient {
	void lock();

	void unlock();

	void isDoorOpen();
}
