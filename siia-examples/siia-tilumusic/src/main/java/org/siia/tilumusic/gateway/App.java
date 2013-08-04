package org.siia.tilumusic.gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String cfg = "org/siia/tilumusic/gateway/context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
        MessageChannel channel = context.getBean("names", MessageChannel.class);
        Message<String> message = MessageBuilder.withPayload("Paradise").build();
        channel.send(message);
    }
}
