package com.in28minutes.microsevices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microsevices.currencyconversionservice.beans.CurrencyConversion;
import com.in28minutes.microsevices.currencyconversionservice.proxyservices.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchnageService;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion doConversionn(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
				.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class,
				uriVariables);
		
		CurrencyConversion conversion = responseEntity.getBody();
		conversion.setQuantity(quantity);
		conversion.setCalculatedAmount(quantity.multiply(conversion.getConversionMultiplpe()) );
		return conversion;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion doConversionnThroughFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion exchangeRate = currencyExchnageService.getexchangeRate(from, to);
		
		
		exchangeRate.setQuantity(quantity);
		exchangeRate.setEnvironment(exchangeRate.getEnvironment().concat(" - FEIGN"));
		exchangeRate.setCalculatedAmount(quantity.multiply(exchangeRate.getConversionMultiplpe()) );
		return exchangeRate;
	}
}
