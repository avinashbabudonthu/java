package com.resource.bundle;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundlePractice {

	/**
	 * Read different properties files based on locale
	 */
	@Test
	public void propertyResourceBundle() {
		Locale enUSLocale = new Locale("en", "US");
		ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("labels", enUSLocale);
		System.out.println(defaultResourceBundle.getString("label1")); // US English Label 1
		System.out.println(defaultResourceBundle.getString("label2.label3")); // US English Label 2.Label 3

		Locale deLocale = new Locale("telugu");
		ResourceBundle daResourceBundle = ResourceBundle.getBundle("labels", deLocale);
		System.out.println(daResourceBundle.getString("label1")); // Telugu Label
		System.out.println(daResourceBundle.getString("label2.label3")); // Telugu Label2.Label3

		// get all keys in a ResourceBundle
		Set<String> keys = defaultResourceBundle.keySet();
		System.out.println("keys: " + keys); // keys: [label2.label3, label1]
	}

	@Test
	public void listResourceBundle() {
		Locale defaultLocale = new Locale("de");
		ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("com.resource.bundle.MyListResourceBundle",
				defaultLocale);
		System.out.println(defaultResourceBundle.getObject("name")); // jack
		System.out.println(defaultResourceBundle.getObject("course")); // Java
		System.out.println(defaultResourceBundle.getObject("grade")); // 3.9

		Locale teluguLocale = new Locale("telugu");
		ResourceBundle teluguResourceBundle = ResourceBundle.getBundle("com.resource.bundle.MyListResourceBundle_telugu",
				teluguLocale);
		System.out.println(teluguResourceBundle.getObject("name")); // john
		System.out.println(teluguResourceBundle.getObject("course")); // Groovy
		System.out.println(teluguResourceBundle.getObject("grade")); // 3.8
	}
}