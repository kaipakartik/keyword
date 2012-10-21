package com.kaipa.keyword.entities;

import javax.persistence.Id;

import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Cached;

@Cached
public class Keyword {
	@Id
	String keyword;
	String url;
	String search;
	long count;

	public Keyword() {
	}

	public Keyword(String keyword, String url, String search, long count) {
		super();
		this.keyword = keyword;
		this.url = url;
		this.search = search;
		this.count = count;
	}

	public Keyword(String keyword, String url) {
		super();
		this.keyword = keyword;
		this.url = url;
		this.search = null;
		this.count = 0;
	}

	public void save() {
		getService().put(this);
	}

	public void incrementCount() {
		count++;
	}

	public static Keyword find(String keyword) {
		Objectify service = getService();
		try {
			return service.get(Keyword.class, keyword);
		} catch (NotFoundException e) {
			return null;
		}
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	private static Objectify getService() {
		return ObjectifyService.begin();
	}
}
