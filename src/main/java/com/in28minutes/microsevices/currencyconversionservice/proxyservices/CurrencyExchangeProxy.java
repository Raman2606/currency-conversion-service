package com.in28minutes.microsevices.currencyconversionservice.proxyservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microsevices.currencyconversionservice.beans.CurrencyConversion;
//without eureka server, wehvae to explicitly mention all theurl in feign client annotation
//@FeignClient(name = "currency-exchange-service" , url = "localhost:8000")

//with naming server
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getexchangeRate(@PathVariable String from, @PathVariable String to) ;
}
