package org.siia.tilumusic.integration.subscription;


import org.siia.tilumusic.domain.Spectator;
import org.siia.tilumusic.domain.User;
import org.springframework.stereotype.Service;


public class GoldSubscriptorProcess {
	User user;

	public Object  sendUser(User  user) {
			this.user=(User)user;
			System.out.println("*********************+Aqui hacemos algo" + 	this.user);
	
		return this.user;
	}

	public User  getOperation(User  user) {
		if (user==null){
			this.user= new Spectator("default");
		}
		System.out.println("*********************+Aqui getOperation  algo->"+user);
		user.setValidated(true);
		return user;
	}





}
