package com.structural.adapter.pattern;

public class MediaAdapter implements MediaPlayer {

	@Override
	public void play(String type, String name) {
		switch (type) {
			case "vlc":
				new VlcPlayer().playVlc(name);
				break;
			case "mp4":
				new Mp4Player().playMp4(name);
				break;
		}
	}

}