package com.trayis.currencyconversioservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trayis.currencyconversioservice.beans.CurrencyConversionBean;
import com.trayis.currencyconversioservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean body = response.getBody();
		return new CurrencyConversionBean(body.getId(), body.getFrom(), body.getTo(), body.getConversionRate(),
				quantity, body.getConversionRate().multiply(quantity), body.getPort());
	}

	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion-feign/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean body = proxy.getEchangeValue(from, to);
		return new CurrencyConversionBean(body.getId(), body.getFrom(), body.getTo(), body.getConversionRate(),
				quantity, body.getConversionRate().multiply(quantity), body.getPort());
	}

}
