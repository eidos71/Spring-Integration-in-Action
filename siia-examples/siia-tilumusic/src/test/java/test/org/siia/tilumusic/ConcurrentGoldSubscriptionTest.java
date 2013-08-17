package test.org.siia.tilumusic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.siia.tilumusic.domain.Spectator;
import org.siia.tilumusic.integration.subscription.CounterSuccesful;
import org.siia.tilumusic.integration.subscription.IPaidSubscriptorProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration("classpath:org/siia/tilumusic/goldsubscribers/ConcurrentGoldSubscription.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class ConcurrentGoldSubscriptionTest {
    @Autowired 
    IPaidSubscriptorProcess iPaidSubscriptorProcess;
    @Autowired@Qualifier("counter")
    CounterSuccesful counterSuccesful;

	@Test
	public void test() {
	       List<Spectator> arrayList= new ArrayList<Spectator>();
	       arrayList.add(new Spectator("ernest"));
	       arrayList.add(new Spectator("albert"));
	       arrayList.add(new Spectator("imma"));
	       for( Spectator spectator: arrayList){
	    	   iPaidSubscriptorProcess.sendUser(spectator );
	    	 System.out.println("****el total es --Z"+ counterSuccesful.getTotal() );
	       }
	     
	}

}
