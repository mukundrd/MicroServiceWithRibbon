package com.trayis.currencyconversioservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trayis.currencyconversioservice.beans.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/{from}/to/{to}")
	CurrencyConversionBean getEchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
