package com.structural.proxy.pattern;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk();
	}

	@Override
	public void display() {
		System.out.println(String.format("display file %s", fileName));
	}

	private void loadFromDisk() {
		System.out.println(String.format("loading file %s from disk", fileName));
	}

}
