package com.trayis.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trayis.currencyexchangeservice.beans.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}
