package com.custom.annotations;

public class Table {

	@Column(name = "col_1", date = "27-08-2019", aliasNames = { "column_1", "column1" })
	private String column1;
}
