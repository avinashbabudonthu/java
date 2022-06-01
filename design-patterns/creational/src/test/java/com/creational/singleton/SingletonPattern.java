package com.creational.singleton;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonPattern {

	@Test
	public void eagerSingleton() {
		EagerSingletonClass obj1 = EagerSingletonClass.getInstnace();
		log.info("{}", obj1);

		EagerSingletonClass obj2 = EagerSingletonClass.getInstnace();
		log.info("{}", obj2);
	}

	@Test
	public void lazySingleton() {
		LazySingletonClass obj1 = LazySingletonClass.getInstance();
		log.info("{}", obj1);

		LazySingletonClass obj2 = LazySingletonClass.getInstance();
		log.info("{}", obj2);
	}

	@Test
	public void usingEnum() {
		Database database1 = Database.INSTANCE;
		Database database2 = Database.INSTANCE;

		log.info("database1={}\ndatabase2={}", database1, database2);
	}

}
