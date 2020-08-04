package com.example.stockexchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockexchange.model.StockExchangeEntity;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchangeEntity, Long> {
 
	Iterable<StockExchangeEntity> findByStockExchange(String stockExchange);
	
}
