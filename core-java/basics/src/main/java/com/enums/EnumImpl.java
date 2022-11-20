package com.enums;

public enum EnumImpl implements IEnum {
	ONE("value 1"), TWO("value 2");

	private String desc;

	private EnumImpl(String desc) {
		this.desc = desc;
	}

	@Override
	public String getDescription() {
		return desc;
	}

}