package org.siia.tilumusic.bussiness.subscription;

public class DJSubscriptionConfirmation {

	String reservationCode;
	String confirmationNumber;
	public void setReservationCode(String reservationCode) {
		this.reservationCode=reservationCode;
		
	}

	public void setConfirmationNumber(String confirmed) {
		this.confirmationNumber=confirmed;
		
	}

	public Object getReservationCode() {
	
		return reservationCode;
	}

}
