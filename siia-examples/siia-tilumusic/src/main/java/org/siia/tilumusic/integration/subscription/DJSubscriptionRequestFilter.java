package org.siia.tilumusic.integration.subscription;
import java.util.regex.Pattern;

import org.siia.tilumusic.bussiness.subscription.DJSubscriptionRequest;

public class DJSubscriptionRequestFilter {
	 Pattern pattern;
	public Pattern getPattern() {
		return pattern;
	}
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
	public DJSubscriptionRequestFilter(Pattern pattern){
		this.pattern=pattern;
	}
	public DJSubscriptionRequestFilter(){
		
	}
	public boolean accept(DJSubscriptionRequest  djSubsRequest) {
		String code = djSubsRequest.getReservationCode();
		return code != null && pattern.matcher(code).matches();
		}
}
