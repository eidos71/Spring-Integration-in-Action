package org.siia.tilumusic.domain;

public class Spectator implements User {
	
	@Override
	public String toString() {
		return "Spectator [name=" + name + ", validated=" + validated + "]";
	}
	private String name;
	private boolean validated;
	public  Spectator(){
		
	}
	public Spectator (String name){
		this. name=name;
	}
	@Override
	public void setValidated(boolean b) {
		this.validated=true;
		
	}

}
