package com.creational.object.pool.pattern;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Connection {

	private String url;
	private String driver;
	private String username;
	private String password;
}