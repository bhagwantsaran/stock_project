package com.example.stockexchange.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockexchange.dto.StockExchangeDTO;
import com.example.stockexchange.model.StockExchangeEntity;
import com.example.stockexchange.service.StockExchangeService;
import com.example.companyretrive.dto.CompanyDTO;

@RestController
public class StockExchangeController {
    

	private StockExchangeService stockExchangeService;
	private CompanyEntity entity;
	
	public StockExchangeController(StockExchangeService stockExchangeService, CompanyEntity entity) {
		super();
		this.stockExchangeService = stockExchangeService;
		this.entity = entity;
	}

	@RequestMapping(value="/stockexchange/{stockExchange}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsByStockExchange(@PathVariable String stockExchange){
		return entity.getCompanyDetailsByStockExchange(stockExchange);
	}
	
	@RequestMapping(value="/stockexchange/{stockExchange}",  method=RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveStockExchange(@RequestBody StockExchangeEntity entity) {
		stockExchangeService.addStockExchange(entity);
	}
	
	@RequestMapping(value="/stockexchange/stockExchangeDetails",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<StockExchangeDTO> getStockExchangesList(){
		return stockExchangeService.getStockExchangesList();
	}
	
	
	
	
}
