package com.columbuscoders.portfoliomanagement.models;

import java.util.Map;

public class Contact {
	
	public Map<String, String> phones;
	public Map<String, String> emails;
	

	// getters
	public Map<String, String> getPhones() {
		return phones;
	}
	
	public Map<String, String> getEmails() {
		return emails;
	}
		
	
	
	//setters
	public void setPhones(Map<String, String> phones) {
		this.phones = phones;
	}

	public void setEmails(Map<String, String> emails) {
		this.emails = emails;
	}

}
