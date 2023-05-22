package com.structural.adapter.pattern;

public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String name) {
		System.out.println("playing vlc " + name);
	}

	@Override
	public void playMp4(String name) {
	}

}