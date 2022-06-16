package com.java.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferencesPractice {

	/**
	 * Strong reference
	 */
	@Test
	public void createStrongReference() {
		Student student = new Student();

		log.info("student={}", student);
	}

	/**
	 * Weak reference
	 * 1. Weak reference is eligible for garbage collection when strong reference is assigned null
	 */
	@Test
	public void createWeakReference() {
		Student student = new Student(); // strong reference
		WeakReference<Student> studentWeakReference = new WeakReference<>(student);

		log.info("student strong reference={}, weak reference={}", student, studentWeakReference);
	}

	/**
	 * Create soft reference
	 *
	 * 1. Soft reference will be garbage collected when
	 *  1.1. when strong reference is assigned null and
	 *  1.2. JVM absolutely needs memory
	 */
	@Test
	public void createSoftReference() {
		Student student = new Student();
		SoftReference<Student> studentSoftReference = new SoftReference<>(student);

		log.info("soft reference={}", studentSoftReference);
	}

	/**
	 * create phantom reference
	 *
	 * 1. Phantom reference will be garbage collected when
	 *  1.1. when strong reference is assigned null and
	 *  1.2. whenever garbage collector likes it
	 */
	@Test
	public void createPhantomReference() {
		Student student = new Student();
		ReferenceQueue<Student> studentReferenceQueue = new ReferenceQueue<>();
		PhantomReference<Student> studentPhantomReference = new PhantomReference<>(student, studentReferenceQueue);
		log.info("student phantom reference={}", studentPhantomReference);
	}

}
