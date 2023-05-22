package com.structural.adapter.pattern;

public class AudioPlayer implements MediaPlayer {

	private MediaAdapter mediaAdapter = new MediaAdapter();

	@Override
	public void play(String type, String name) {
		switch (type) {
			case "vlc":
			case "mp4":
				mediaAdapter.play(type, name);
				break;
			case "mp3":
				System.out.println("playing mp3 " + name);
				break;
			default:
				System.out.println("invalid media type");
				break;
		}
	}

}