package com.safa.temperature.soap.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safa.temperature.soap.api.services.TemperatureService;
import com.safa.temperature.soap.api.temperatureRequestResponse.AvgTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.AvgTemperatureResponse;
import com.safa.temperature.soap.api.temperatureRequestResponse.ClosestToZeroTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.ClosestToZeroTemperatureResponse;
import com.safa.temperature.soap.api.temperatureRequestResponse.MaxTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.MaxTemperatureResponse;
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

	@PostMapping("/max")
	public MaxTemperatureResponse testConsumeMax(@RequestBody MaxTemperatureRequest request) {
		return service.getMaxTemperature(request);
	}

	@PostMapping("/avg")
	public AvgTemperatureResponse testConsumeAvg(@RequestBody AvgTemperatureRequest request) {
		return service.getAvgTemperature(request);
	}

	@PostMapping("/ClosestToZero")
	public ClosestToZeroTemperatureResponse testConsumeClosestToZero(@RequestBody ClosestToZeroTemperatureRequest request) {
		return service.getClosestToZeroTemperature(request);
	}
}
