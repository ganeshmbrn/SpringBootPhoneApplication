package com.ganesh.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("application")
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "phonebook")
public class ApplicationProperties {

	private Map<String,String> messages = new HashMap<String, String>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
}