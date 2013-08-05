package org.siia.tilumusic.bussiness;

import org.siia.tilumusic.domain.DJStreamStatus;
import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.Publisher;
import org.springframework.stereotype.Service;

@Service
public class SimpleDJStreamStatusService  implements DJStreamStatusService{

	@Publisher(channel="statisticsChannel")
	@Override
	public DJStreamStatus updateStatus(@Payload DJStreamDelayEvent djEventDelayEvent) {
		// TODO Auto-generated method stub
		return new DJStreamStatus();
	}

}
