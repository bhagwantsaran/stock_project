package com.example.iposervice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.iposervice.dto.IpoDTO;
import com.example.iposervice.service.IpoService;

@RestController
public class IpoController {
	@Autowired
	private IpoService ipoService;
	
	@RequestMapping(value = "/companyipo/{company_name}", method = RequestMethod.GET)
	public IpoDTO getCompanyIpoDetails(@PathVariable String company_name) throws Exception
	{
		return ipoService.getCompanyIpoDetails(company_name);
	}
	

}
