package com.example.sector.ui;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.companyretrive.dto.CompanyDTO;

@FeignClient("company-retrive")
public interface CompanyEntity {
  
	@RequestMapping(value="/{sector}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsBySector(@PathVariable String sector);
	
	@RequestMapping(value="/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice(String sector_name,@PathVariable Date from,@PathVariable  Date to,@PathVariable  int period);
		
	
}
