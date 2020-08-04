package com.example.stockexchange.service;

import com.example.companyretrive.dto.CompanyDTO;
import com.example.stockexchange.dto.StockExchangeDTO;
import com.example.stockexchange.model.StockExchangeEntity;

public interface StockExchangeService {

	
	Iterable<StockExchangeDTO> getStockExchangesList();
	 void addStockExchange(StockExchangeEntity entity);
	 Iterable<CompanyDTO> getCompaniesList(String stockExchange);
}
