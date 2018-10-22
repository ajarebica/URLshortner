package com.shorturltask.shortner;

import java.util.HashMap;
import java.util.Map;

public class UrlData {

	private static Map<Integer, Url> urls = new HashMap<>();
	
	public static Map<Integer, Url> getUrls() {
		return urls;
	}
}