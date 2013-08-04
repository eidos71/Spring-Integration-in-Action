package org.siia.tilumusic.bussiness;

import java.util.Date;

import org.siia.tilumusic.domain.DJStream;
import org.springframework.util.Assert;

public class DJStreamDelayEvent {
	private DJStream djEvent;;
	private Date estimatedDeparture;
	
	public DJStreamDelayEvent(DJStream djevent, Date estmidated){
		Assert.notNull(djevent);
		Assert.notNull(estmidated);
		this.djEvent=djevent;
		this.estimatedDeparture=estmidated;
	}

	public Date getNextDjStreamEvent() {
		
		return estimatedDeparture;
	}
}
