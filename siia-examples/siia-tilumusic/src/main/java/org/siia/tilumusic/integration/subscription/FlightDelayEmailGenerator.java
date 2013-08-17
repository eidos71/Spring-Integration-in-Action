package org.siia.tilumusic.integration.subscription;


import org.siia.tilumusic.domain.Spectator;
import org.siia.tilumusic.domain.User;
import org.springframework.stereotype.Service;


public class FlightDelayEmailGenerator {
	User user;

	public Object  sendCancellation(User  user) {
		System.out.println("*********************+Aqui hacemos algo" + user);
		if (user instanceof  User){
			this.user=(User)user;
		}
	
		return this.user;
	}

	public User  getOperation() {
		if (this.user==null){
			this.user= new Spectator("default");
		}
		System.out.println("*********************+Aqui getOperation  algo+"+this.user);
		user.setValidated(true);
		return user;
	}





}
