package test.org.siia.tilumusic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.domain.Invoice;
import org.siia.tilumusic.domain.payment.CreditCardPayment;
import org.siia.tilumusic.domain.payment.CreditCardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration("classpath:org/siia/tilumusic/channel/routingPayloadExample.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoutingTest {


    @Autowired @Qualifier("payments")
    MessageChannel paymentschannel;

    @Autowired @Qualifier("credit-card-payments")
    PollableChannel creditcardchannel;
	@Test
	public void test() {
		paymentschannel.send(MessageBuilder.withPayload(new Invoice()).build());
	}
	 @Test
	    public void testCreditCardRouting() {
	      CreditCardPayment payment = new CreditCardPayment();
	      payment.setCreditCardType(CreditCardType.MASTERCARD);
	      paymentschannel.send(MessageBuilder.withPayload(payment).build());
	      Message<?> result = creditcardchannel.receive(0);
	      assertNotNull(result);
	      assertEquals(CreditCardPayment.class, result.getPayload().getClass());
	      assertEquals(payment, result.getPayload());
	    }
}
