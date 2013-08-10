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
@ContextConfiguration("classpath:org/siia/tilumusic/gateway/jmsgateway.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJmsGateway {
	@Resource(name = "toJMS")
	MessageChannel toJMS;
	@Resource (name="jmsReplies")
	PollableChannel  jmsReplies;
	@Test
	public void testGateway() {
		MessagingTemplate template = new MessagingTemplate();
		template.convertAndSend(toJMS, "echo");
		Object response = template.receiveAndConvert(jmsReplies);
		assertNotNull(response);
		assertTrue("ECHO".equals(response.toString() ) );
	}

}
