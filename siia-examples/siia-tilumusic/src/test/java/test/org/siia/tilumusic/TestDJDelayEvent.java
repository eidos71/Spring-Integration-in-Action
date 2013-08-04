package test.org.siia.tilumusic;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.bussiness.DJStreamDelayEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration("classpath:djnextevent.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDJDelayEvent {

	@Autowired
	private MessageChannel djStreamDelayInput;
	@Autowired
	private PollableChannel delayEvents;
	
	@Test
	public void verifyDelay() {
		long currentTime = System.currentTimeMillis();
		Message<String> message =
		MessageBuilder.withPayload("DJHaz+0130").build();
		djStreamDelayInput.send(message);
		Message<?> transformed = delayEvents.receive(0);
		assertNotNull(transformed);
		Object payload = transformed.getPayload();
		assertNotNull(payload);
		assertEquals(DJStreamDelayEvent.class, payload.getClass());
		Date estimatedNextDJStreamEvent =
				((DJStreamDelayEvent) payload).getNextDjStreamEvent();
		long secondsFor1hr30min = 90 * 60;
		long delay = estimatedNextDJStreamEvent.getTime() - currentTime;
		System.out.println("estimatedNextDJStreamEvent.getTime() " + estimatedNextDJStreamEvent.getTime() );
		System.out.println("delay->" + delay);
		System.out.println("secondsFor1hr30min" + secondsFor1hr30min);
		
		assertEquals(secondsFor1hr30min, delay / 1000);
	}

}
