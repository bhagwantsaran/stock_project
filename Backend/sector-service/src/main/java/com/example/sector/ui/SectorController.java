package com.example.sector.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.companyretrive.dto.CompanyDTO;
import com.example.sector.service.SectorService;

import java.util.*;
@RestController
public class SectorController {
	
	
	@Autowired
	SectorService sectorService;
	
	@Autowired
	CompanyEntity companyEntity;
	
	@RequestMapping(value="/sector_stock_price/{sector_id}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice(@PathVariable Long sectorId,@PathVariable  Date from,@PathVariable  Date to,@PathVariable  int period) {
		String sector=sectorService.getSectorName(sectorId);
		return companyEntity.getSectorPrice(sector, from, to, period);
	}
    
	
	@RequestMapping(value="/{sectorId}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<CompanyDTO>> getCompanyList(@PathVariable Long sectorId) {
		
		String sector=sectorService.getSectorName(sectorId);
		ResponseEntity<List<CompanyDTO>> companyDetailsBySector = (ResponseEntity<List<CompanyDTO>>) companyEntity.getCompanyDetailsBySector(sector);
		return companyDetailsBySector;
	}

}
