package com.example.uploadservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadservice.model.StockPriceEntity;
import com.example.uploadservice.repository.UserRepository;


@Service
public class UploadServiceImpl implements UploadService {

	
	@Autowired
	 UserRepository repo;
	
	@Override
	public List<StockPriceEntity> addStockPrice(List<StockPriceEntity> list) {
		
		for(StockPriceEntity entity:list)
			repo.save(entity);
		
		return list;
			
	}

}
