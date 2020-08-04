package com.example.stockexchange.dto;

import com.example.stockexchange.model.StockExchangeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockExchangeDTO {
  
	private String stockExchange;
	private String brief;
	private String address;
	private String remarks;
}
