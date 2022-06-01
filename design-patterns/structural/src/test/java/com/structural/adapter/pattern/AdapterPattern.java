package com.structural.adapter.pattern;

import org.junit.Test;

public class AdapterPattern {

	@Test
	public void execute() {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "file1");
		audioPlayer.play("mp4", "file2");
		audioPlayer.play("vlc", "file3");
		audioPlayer.play("mp5", "file4");
	}
}