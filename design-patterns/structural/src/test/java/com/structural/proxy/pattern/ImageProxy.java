package com.structural.proxy.pattern;

import java.util.Objects;

public class ImageProxy implements Image {

	private RealImage realImage;
	private String fileName;

	public ImageProxy(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (Objects.isNull(realImage)) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}