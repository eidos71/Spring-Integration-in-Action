package org.siia.tilumusic.domain.payment;


public class PaypalPayment extends PaymentSettlement {
	public PaypalPayment(){
		System.out.println (this.getClass().getSimpleName());
	}
}
