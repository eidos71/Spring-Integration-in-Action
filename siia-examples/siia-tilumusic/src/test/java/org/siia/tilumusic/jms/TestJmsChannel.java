package org.siia.tilumusic.jms;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.core.PollableChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:org/siia/tilumusic/channel/jmsChannelExample.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJmsChannel {
	@Resource(name = "toJMS")
	MessageChannel toJMS;
	@Resource(name = "fromJMS")
	PollableChannel fromJMS;

	@Test
	public void testGateway() {
		MessagingTemplate template = new MessagingTemplate();
		template.convertAndSend(toJMS, "echo");
		Object response = template.receiveAndConvert(fromJMS);
		assertNotNull(response);
		assertTrue("echo".equals(response.toString()));
	}

}
