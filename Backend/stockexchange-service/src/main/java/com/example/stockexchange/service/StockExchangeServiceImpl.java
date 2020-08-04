package com.example.stockexchange.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.companyretrive.dto.CompanyDTO;
import com.example.stockexchange.dto.StockExchangeDTO;
import com.example.stockexchange.model.StockExchangeEntity;
import com.example.stockexchange.repository.StockExchangeRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	
	@Autowired
	StockExchangeRepository repo;
	
	@Override
	public Iterable<StockExchangeDTO> getStockExchangesList() {
		
		List<StockExchangeDTO> list = new ArrayList<>();
	    Iterable<StockExchangeEntity> companyEntity=repo.findAll();
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(StockExchangeEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, StockExchangeDTO.class));
	    }
	    Iterable<StockExchangeDTO> dto=list;
		return dto;
	}

	@Override
	public void addStockExchange(StockExchangeEntity entity) {
		repo.save(entity);
	}

	@Override
	public Iterable<CompanyDTO> getCompaniesList(String stockExchange) {
		return null;
	}

}
