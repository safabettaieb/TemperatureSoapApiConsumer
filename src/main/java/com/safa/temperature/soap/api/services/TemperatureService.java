package com.safa.temperature.soap.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureRequest;
import com.safa.temperature.soap.api.temperatureRequestResponse.MinTemperatureResponse;

@Service
public class TemperatureService {
	@Autowired
	private Jaxb2Marshaller marshaller;
	private WebServiceTemplate template;
	private final String URL = "http://localhost:8081/api";

	public MinTemperatureResponse getMinTemperature(MinTemperatureRequest request) {
		template = new WebServiceTemplate(marshaller);
		MinTemperatureResponse response = (MinTemperatureResponse) template.marshalSendAndReceive(URL, request);
		return response;
	}

}
