package org.siia.tilumusic.domain.subscription;

import org.siia.tilumusic.bussiness.subscription.DJSubscriptionConfirmation;
import org.siia.tilumusic.bussiness.subscription.DJSubscriptionRequest;


public class StubDjSubscriptionService  implements DJSubscriptionService{

    private static final String CONFIRMED = "*CONFIRMED*";

	@Override
	public DJSubscriptionConfirmation subscribe(
			DJSubscriptionRequest dJSubscriptionRequest) {
		DJSubscriptionConfirmation dJSubscriptionConfirmation = new DJSubscriptionConfirmation();
		dJSubscriptionConfirmation.setReservationCode(dJSubscriptionRequest.getReservationCode());
		dJSubscriptionConfirmation.setConfirmationNumber(CONFIRMED);
        return dJSubscriptionConfirmation;
	}

}
