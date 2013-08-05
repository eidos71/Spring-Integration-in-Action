package org.siia.tilumusic.domain.subscription;

import org.siia.tilumusic.bussiness.subscription.DJSubscriptionConfirmation;
import org.siia.tilumusic.bussiness.subscription.DJSubscriptionRequest;



public interface DJSubscriptionService {
	 DJSubscriptionConfirmation subscribe( DJSubscriptionRequest  dJSubscriptionRequest);
}
