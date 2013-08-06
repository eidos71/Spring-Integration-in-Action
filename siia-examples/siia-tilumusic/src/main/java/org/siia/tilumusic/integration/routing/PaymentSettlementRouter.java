package org.siia.tilumusic.integration.routing;

import org.siia.tilumusic.domain.Invoice;
import org.siia.tilumusic.domain.payment.CreditCardPayment;
import org.siia.tilumusic.domain.payment.DirectDebitPayment;
import org.siia.tilumusic.domain.payment.PaymentSettlement;
import org.siia.tilumusic.domain.payment.PaypalPayment;


public class PaymentSettlementRouter {
	public String routePaymentSettlement(PaymentSettlement paymentSettlement) {
		String destinationChannel = null;
		if (paymentSettlement instanceof CreditCardPayment)
			destinationChannel = "credit-card-payments";
		if (paymentSettlement instanceof Invoice)
			destinationChannel = "invoices";
		if (paymentSettlement instanceof DirectDebitPayment)
			destinationChannel = "direct-debit-payments";
		if (paymentSettlement instanceof PaypalPayment)
			destinationChannel = "paypal-payments";
		return destinationChannel;
	}
}
