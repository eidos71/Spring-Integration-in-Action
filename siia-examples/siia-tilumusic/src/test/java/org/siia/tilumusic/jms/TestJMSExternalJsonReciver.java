package org.siia.tilumusic.jms;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.domain.DJStreamStatus;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.core.SubscribableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:org/siia/tilumusic/gateway/ExternalGatewaysJMSReciver.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJMSExternalJsonReciver {

	@Resource(name = "transformerchannel")
	PollableChannel  transformerchannel;

	@Test
	public void testRecive(){
		MessagingTemplate template = new MessagingTemplate();
	
		
		Object response = template.receiveAndConvert(transformerchannel);
		System.out.println("response---------->"+response);
	}
}
