package org.siia.tilumusic.bussiness;

import org.siia.tilumusic.domain.DJStreamStatus;

public interface DJStreamStatusService {
	
		DJStreamStatus updateStatus(DJStreamDelayEvent djEventDelayEvent);
		
}
