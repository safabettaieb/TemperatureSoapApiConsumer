package com.safa.temperature.soap.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safa.temperature.soap.api.services.TemperatureService;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureResponse;

@RestController
@RequestMapping("/test")
public class TestTemperatureConsume {
	@Autowired
	TemperatureService service;
	
	
	@PostMapping("/min")
	public MinTemperatureResponse testConsumeMin(@RequestBody MinTemperatureRequest request) {
		return service.getMinTemperature(request);
	}

}
