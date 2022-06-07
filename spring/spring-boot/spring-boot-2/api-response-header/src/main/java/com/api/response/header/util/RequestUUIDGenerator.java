package com.api.response.header.util;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public final class RequestUUIDGenerator {

	private static final int INITIAL_SIZE = 250;
	private static final int MIN_SIZE = 5;
	private static final BlockingQueue<UUID> UUID_POOL = new ArrayBlockingQueue<UUID>(INITIAL_SIZE);
	private final Object lock = new Object();

	public RequestUUIDGenerator() {
		generateUUIDs(INITIAL_SIZE);
	}

	private void generateUUIDs(int numberOfUUIDs) {
		for (int i = 0; i < numberOfUUIDs; i++) {
			UUID_POOL.add(UuidUtil.getTimeBasedUuid());
		}
	}

	private UUID getNextUUID() {
		UUID nextUUID = null;
		try {
			nextUUID = UUID_POOL.take();
			synchronized (lock) {
				if (UUID_POOL.size() < MIN_SIZE) {
					generateUUIDs(INITIAL_SIZE - UUID_POOL.size());
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return nextUUID;
	}

	public String nextUUID() {
		return String.valueOf(getNextUUID());
	}
}