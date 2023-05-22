package com.structural.adapter.pattern;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String name) {
	}

	@Override
	public void playMp4(String name) {
		System.out.println("playing mp4 " + name);
	}

}