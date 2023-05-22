package com.creational.singleton;

/**
 * Create object if not created on calling getInstance() method
 * To avoid multiple instance with multiple threads use synchronized
 *
 */
public class LazySingletonClass {

	private static LazySingletonClass INSTANCE = null;
	private static Object lock = new Object();

	private LazySingletonClass() {
	}

	public static LazySingletonClass getInstance() {
		synchronized (lock) {
			if (null == INSTANCE)
				INSTANCE = new LazySingletonClass();
		}
		return INSTANCE;
	}

}
