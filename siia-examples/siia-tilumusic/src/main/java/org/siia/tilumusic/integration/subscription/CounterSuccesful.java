package org.siia.tilumusic.integration.subscription;



import org.siia.tilumusic.domain.Spectator;
import org.siia.tilumusic.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;



public class CounterSuccesful {
		int total;

		@ServiceActivator
	    public User count(@Payload User  user) {
	    	System.out.println("*****************************************************HELLO");
	    
       if (user instanceof Spectator){
	    	   System.out.println("Assembled car " +((Spectator) user).toString() );
	    		this.total=total+1;
	       }
	    return user;
	    }

		public int getTotal() {
			return this.total;
		}

	 
}
