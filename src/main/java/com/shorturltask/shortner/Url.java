package com.shorturltask.shortner;

public class Url {
	
	private String url;
	private Integer id;
	
	public Url(String urlstring, Integer id){
		this.url = urlstring;
		this.id = id;
	}
	
	public Url() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
