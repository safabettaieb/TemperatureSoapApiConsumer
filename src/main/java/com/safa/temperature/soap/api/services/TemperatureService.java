package com.safa.temperature.soap.api.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.safa.temperature.soap.api.temperatureRequestResponse.MaxTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.MaxTemperatureResponse;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureResponse;

@Service
public class TemperatureService {
	@Autowired
	private Jaxb2Marshaller marshaller;
	private WebServiceTemplate template;
	private final String URL = "http://localhost:8081/api";

	@PostConstruct
	public void init() {
		template = new WebServiceTemplate(marshaller);
	}

	public MinTemperatureResponse getMinTemperature(MinTemperatureRequest request) {

		MinTemperatureResponse response = (MinTemperatureResponse) template.marshalSendAndReceive(URL, request);
		return response;
	}
	
	public MaxTemperatureResponse getMaxTemperature(MaxTemperatureRequest request) {

		MaxTemperatureResponse response = (MaxTemperatureResponse) template.marshalSendAndReceive(URL, request);
		return response;
	}
	

}
