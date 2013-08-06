package test.org.siia.tilumusic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.bussiness.subscription.DJSubscriptionConfirmation;
import org.siia.tilumusic.bussiness.subscription.DJSubscriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:org/siia/tilumusic/goldsubscribers/djHookingevent.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDJStreamSubscription {
    @Autowired @Qualifier("input")
    MessageChannel input;

    @Autowired @Qualifier("confirmed")
    PollableChannel confirmed;

    @Autowired @Qualifier("rejected")
    PollableChannel rejected;

    @Test
    public void testSubscriptionGold() {
    	DJSubscriptionRequest dJSubscriptionRequest = new DJSubscriptionRequest();
    	dJSubscriptionRequest.setReservationCode("GOLD123456");
        input.send(MessageBuilder.withPayload(dJSubscriptionRequest).build());
        Message<?> confirmedMessage = confirmed.receive(0);
        assertNotNull(confirmedMessage);
        assertEquals(DJSubscriptionConfirmation.class, confirmedMessage.getPayload().getClass());
        DJSubscriptionConfirmation confirmation = (DJSubscriptionConfirmation) confirmedMessage.getPayload();
        assertEquals("GOLD123456", confirmation.getReservationCode());
    }
    @Test
    public void TestSubscriptionNormal(){
    	DJSubscriptionRequest dJSubscriptionRequest = new DJSubscriptionRequest();
    	dJSubscriptionRequest.setReservationCode("SILVER123456");
        input.send(MessageBuilder.withPayload(dJSubscriptionRequest).build());
        Message<?> confirmedMessage = confirmed.receive(0);
        assertNull(confirmedMessage);
        Message<?> rejectedMessage = rejected.receive(0);
        assertNotNull(rejectedMessage);
        assertEquals(DJSubscriptionRequest.class, rejectedMessage.getPayload().getClass());
        DJSubscriptionRequest request = (DJSubscriptionRequest) rejectedMessage.getPayload();
        assertEquals("SILVER123456", request.getReservationCode());
    }

}
