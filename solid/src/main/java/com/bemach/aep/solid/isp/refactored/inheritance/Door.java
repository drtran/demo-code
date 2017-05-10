package com.bemach.aep.solid.isp.refactored.inheritance;

/**
 * Door is now not a 'fat' interface
 * 
 *
 */
public interface Door {
	void lock();

	void unlock();

	void isDoorOpen();
}
