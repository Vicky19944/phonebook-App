package com.api.phonebook.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "phonebook")
public class AppProperties {

	private Map<String, String> massages= new HashMap<>();

	public Map<String, String> getMassages() {
		return massages;
	}

	public void setMassages(Map<String, String> massages) {
		this.massages = massages;
	}

	public AppProperties(Map<String, String> massages) {
		super();
		this.massages = massages;
	}

	
}
