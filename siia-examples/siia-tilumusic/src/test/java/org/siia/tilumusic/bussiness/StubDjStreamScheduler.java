package org.siia.tilumusic.bussiness;

import java.util.Date;

import org.siia.tilumusic.domain.DJStream;

/**
 * StubDjStreamScheduler to test information.
 * This is mainly a test class.
 * @author eidos71
 *
 */
public class StubDjStreamScheduler implements DJStreamScheduler {
	@Override
	public DJStream nextEventForNumber(String djEventNumber) {
		DJStream djEvent = new DJStream(djEventNumber);
		djEvent.setScheduledDeparture(new Date());
		djEvent.setDJCode("DJHaz");
		djEvent.setDestination("CHI");
		return djEvent;
		}

}
