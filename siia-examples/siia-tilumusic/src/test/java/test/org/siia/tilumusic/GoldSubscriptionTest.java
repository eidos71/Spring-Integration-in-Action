package test.org.siia.tilumusic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.domain.Invoice;
import org.siia.tilumusic.domain.Spectator;
import org.siia.tilumusic.domain.payment.CreditCardPayment;
import org.siia.tilumusic.domain.payment.CreditCardType;
import org.siia.tilumusic.integration.subscription.IPaidSubscriptorProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
@ContextConfiguration("classpath:org/siia/tilumusic/goldsubscribers/GoldSubscriptionEvent.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GoldSubscriptionTest {

	@Autowired @Qualifier ("confirmed")
	PollableChannel confirmed;
    @Autowired @Qualifier("inputchannel")
    MessageChannel inputchannel;
    @Autowired 
    IPaidSubscriptorProcess iPaidSubscriptorProcess;

	
	@Test
	public void test() {
		Assert.notNull(iPaidSubscriptorProcess);
//		CreditCardPayment payment = new CreditCardPayment();
//	      payment.setCreditCardType(CreditCardType.MASTERCARD);
	     
	       List<Spectator> arraylist= new ArrayList<Spectator>();
	       arraylist.add(new Spectator("ernest"));
	       arraylist.add(new Spectator("albert"));
	       arraylist.add(new Spectator("imma"));
	      for (Spectator spectator: arraylist){
	    	 inputchannel.send(MessageBuilder.withPayload(spectator).build() );
	    	// iPaidSubscriptorProcess.sendUser(spectator);
	      }
	    
	   //   Message<?> a= validated.receive();
	    // System.out.pr	<int:queue></int:queue>intln("-->"+ a.getPayload().getClass() );
	   //  iPaidSubscriptorProcess.sendUser(spectator);
	    
	     //iPaidSubscriptorProcess.sendUser(spectator);
	    // iPaidSubscriptorProcess.getOperation();
	      //System.out.println("***********"+d.toString() );
	  //  iPaidSubscriptorProcess.getOperation();
	    // inputchannel.send(  MessageBuilder.withPayload(spectator).build() );
	      Message<?> a =confirmed.receive(0);
	      System.out.println("***********"+a.toString() );
	}

}
