package org.siia.tilumusic.bussiness;

import org.siia.tilumusic.domain.DJStream;

public interface DJStreamScheduler {

	DJStream nextEventForNumber(String djEventNumber);

}
