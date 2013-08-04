package org.siia.tilumusic.bussiness;

import org.siia.tilumusic.domain.DJStreamStatus;

public class DJStreamStatusServiceImpl implements DJStreamStatusService {

	@Override
	public DJStreamStatus updateStatus(DJStreamDelayEvent djEventDelayEvent) {
		System.out.println(djEventDelayEvent.toString());
		
		return new DJStreamStatus();
	}

}
