package com.example.sector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sector.repository.SectorRepository;

@Service
public class SectorServiceImpl implements SectorService {
   
	@Autowired
	SectorRepository repo;

	@Override
	public String getSectorName(Long sectorId) {
		return  repo.getSector(sectorId);
	}


	


}
