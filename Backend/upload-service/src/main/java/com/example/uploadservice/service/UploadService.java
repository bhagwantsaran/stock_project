package com.example.uploadservice.service;

import java.util.List;

import com.example.uploadservice.model.StockPriceEntity;

public interface UploadService {
 
	List<StockPriceEntity> addStockPrice(List<StockPriceEntity> list);
	
}
