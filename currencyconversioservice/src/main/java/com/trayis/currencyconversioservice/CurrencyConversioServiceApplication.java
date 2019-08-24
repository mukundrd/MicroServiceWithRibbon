package com.trayis.currencyconversioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.trayis.currencyconversioservice")
public class CurrencyConversioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversioServiceApplication.class, args);
	}

}
