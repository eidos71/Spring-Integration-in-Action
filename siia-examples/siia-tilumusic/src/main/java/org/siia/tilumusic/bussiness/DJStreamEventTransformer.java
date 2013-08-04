package org.siia.tilumusic.bussiness;

import java.util.Calendar;

import org.siia.tilumusic.domain.DJStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


public class DJStreamEventTransformer {
	private final DJStreamScheduler djEventScheduler;

	@Autowired
	public DJStreamEventTransformer(DJStreamScheduler djEventScheduler) {
		Assert.notNull(djEventScheduler);
		this.djEventScheduler = djEventScheduler;
	}
	public DJStreamDelayEvent convertToDelayEvent(
			String flightNumberAndDelay) {
			String[] splits = flightNumberAndDelay.split("[+]");
			DJStream djEvent =
			this.djEventScheduler.nextEventForNumber(splits[0]);
			int hours = Integer.parseInt(splits[1].substring(0, 2));
			int minutes = Integer.parseInt(splits[1].substring(2));
			Calendar cal = Calendar.getInstance();
			cal.setTime(djEvent.getDeparture());
			cal.add(Calendar.HOUR, hours);
			cal.add(Calendar.MINUTE, minutes);
			return new DJStreamDelayEvent(djEvent, cal.getTime());
			}
}
