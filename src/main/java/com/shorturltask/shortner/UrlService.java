package com.shorturltask.shortner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UrlService {
	
	private Map<Integer, Url> urls = UrlData.getUrls();
	private AtomicInteger idCounter = new AtomicInteger();
	
	public List<Url> getAllUrls() {
		return new ArrayList<Url>(urls.values()); 
	}
	
	public Url addUrl(Url url) {

		urls.put(idCounter.incrementAndGet(), new Url(url.getUrl(), idCounter.incrementAndGet()));
		return url;
	}
}
