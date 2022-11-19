package com.resource.bundle;

import java.util.ListResourceBundle;

public class MyListResourceBundle_telugu extends ListResourceBundle {

	private Object[][] contents = { { "name", "john" }, { "course", "Groovy" }, { "grade", 3.8 } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
