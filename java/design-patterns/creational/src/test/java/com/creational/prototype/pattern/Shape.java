package com.creational.prototype.pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Shape implements Cloneable {

	@Getter
	@Setter
	private String id;

	@Getter
	protected String type;

	public abstract void draw();

	@Override
	protected Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			log.error("Exception", e);
		}
		return clone;
	}
}