package com.trayis.limitservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trayis.limitservice.configurations.Configuration;
import com.trayis.limitservice.controllers.beans.LimitsConfiguration;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitConfigurations() {
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

}
