package com.bemach.aep.pisentry.utils;

import java.util.Hashtable;

public class TestUtis {

	private static Hashtable<String, Object> hash = new Hashtable<String, Object>();

	public static Object get(String key) {
		return hash.get(key);
	}
	
	public static void put(String key, Object value) {
		hash.put(key, value);
	}
}
