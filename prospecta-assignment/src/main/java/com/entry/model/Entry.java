package com.entry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty("API")
	private String api;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("Https")
	private boolean hTTPS;
	
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Link")
	private String link;
	
	@JsonProperty("Category")
	private String category;
	
	public Entry() {
		
	}

	public Entry(String api, String description, String auth, boolean hTTPS, String cors, String link,
			String category) {
		super();
		this.api = api;
		this.description = description;
		this.auth = auth;
		this.hTTPS = hTTPS;
		this.cors = cors;
		this.link = link;
		this.category = category;
	}
	
	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public boolean ishTTPS() {
		return hTTPS;
	}

	public void sethTTPS(boolean hTTPS) {
		this.hTTPS = hTTPS;
	}

	public String getCors() {
		return cors;
	}

	public void setCors(String cors) {
		this.cors = cors;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
}
