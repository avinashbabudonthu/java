package com.enums;

public enum EnumMethods {

	// @formatter:off
	MONDAY{
		@Override
		public String lowerCase() {
			return MONDAY.toString().toLowerCase();
		}
		
		@Override
		public String capitalize() {
			return this.toString();
		}
	}, 
	
	TUESDAY {
		@Override
		public String lowerCase() {
			return TUESDAY.toString().toLowerCase();
		}
	}, 
	
	WEDNESDAY {
		@Override
		public String lowerCase() {
			return WEDNESDAY.toString().toLowerCase();
		}
	};
	// @formatter:on

	// abstract method has to be overridden in all enum values
	public abstract String lowerCase();

	// general implementation, can be overridden in required enum values like in MONDAY
	public String capitalize() {
		String string = this.toString().toLowerCase();
		return string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
	}
}