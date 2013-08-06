package org.siia.tilumusic.domain.payment;


public class CreditCardPayment extends PaymentSettlement {

	private CreditCardType creditCardType;
	public void setCreditCardType(CreditCardType creditcard) {
		this.creditCardType=creditcard;
	}

}
