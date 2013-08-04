package org.siia.tilumusic.common;


public class MyTiluMusicService  implements TiluMusicService{

	@Override
	public void playMusic(String song) {
		System.out.println("Play "+ song);
		
	}

	@Override
	public void playMusic() {
		System.out.println("Play ");
		
	}

}
