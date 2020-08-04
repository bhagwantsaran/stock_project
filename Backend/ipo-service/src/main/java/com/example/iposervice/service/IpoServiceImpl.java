package com.example.iposervice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iposervice.dao.IpoRepository;
import com.example.iposervice.dao.entities.IpoEntity;
import com.example.iposervice.dto.IpoDTO;

@Service
public class IpoServiceImpl implements IpoService{
	@Autowired
	IpoRepository ipoRepository;
	
	@Override
	public IpoDTO getCompanyIpoDetails(String company_name) throws Exception
	{ IpoEntity ipoEntity = ipoRepository.findByCompanyName(company_name);
	  
		IpoDTO ipoDto=null;
    	ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    ipoDto=mapper.map(ipoEntity, IpoDTO.class);
		return ipoDto;
	}

}
