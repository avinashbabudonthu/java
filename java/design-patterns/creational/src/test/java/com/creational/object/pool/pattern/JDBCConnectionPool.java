package com.creational.object.pool.pattern;

public class JDBCConnectionPool extends ObjectPool<Connection> {

	private String url;
	private String driver;
	private String username;
	private String password;

	public JDBCConnectionPool(String url, String driver, String username, String passsword) {
		this.url = url;
		this.driver = driver;
		this.username = username;
		this.password = passsword;
	}

	@Override
	Connection create() {
		return Connection.builder().url(url).driver(driver).username(username).password(password).build();
	}

	@Override
	boolean validate(Connection o) {
		return null != o;
	}

	@Override
	void dead(Connection o) {
		o = null;
	}

}
