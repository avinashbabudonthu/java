package com.creational.object.pool.pattern;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {

	long deadTime;

	Hashtable<T, Long> lock;

	Hashtable<T, Long> unlock;

	ObjectPool() {
		deadTime = 50000L;
		lock = new Hashtable<>();
		unlock = new Hashtable<>();
	}

	abstract T create();

	abstract boolean validate(T o);

	abstract void dead(T o);

	synchronized T takeOut() {
		long now = System.currentTimeMillis();

		T t;
		if (unlock.size() > 0) {
			Enumeration<T> keys = unlock.keys();
			while (keys.hasMoreElements()) {
				t = keys.nextElement();
				if ((now - unlock.get(t)) > deadTime) {
					unlock.remove(t);
					dead(t);
					t = null;
				} else {
					if (validate(t)) {
						unlock.remove(t);
						lock.put(t, now);
						return t;
					} else {
						unlock.remove(t);
						dead(t);
						t = null;
					}
				}
			}
		}

		t = create();
		lock.put(t, now);
		return t;
	}

	synchronized void takeIn(T t) {
		lock.remove(t);
		unlock.put(t, System.currentTimeMillis());
	}
}