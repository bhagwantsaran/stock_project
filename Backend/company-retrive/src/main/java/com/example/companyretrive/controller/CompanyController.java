package com.example.companyretrive.controller;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.companyretrive.dto.CompanyDTO;
import com.example.companyretrive.dto.IpoDTO;
import com.example.companyretrive.dto.StockPriceDTO;
import com.example.companyretrive.service.CompanyService;



@RestController
public class CompanyController {
	   @Autowired
	    private CompanyService companyService;

	   
	    @RequestMapping(value = "/company/{companyName}", method = RequestMethod.GET)
	    public CompanyDTO getCompany(@PathVariable String companyName) throws Exception {
	    	
	        CompanyDTO companyDTO= companyService.getCompany(companyName);
	       // System.out.println(companyDTO.getCompany_name());
	        return companyDTO;
	    }
	    @RequestMapping(value = "/company/stockprice/{companyId}&{fromDate}&{toDate}&{periodicity}", method = RequestMethod.GET)
	    public List<Float> getStockPrice(@PathVariable long companyId,@PathVariable Date fromDate,@PathVariable Date toDate,@PathVariable int periodicity)throws Exception
	    {
	    	List<Float> stockPriceDTO=companyService.getStockPrice(companyId,fromDate,toDate,periodicity);
	    	return stockPriceDTO;
	    }
	    @RequestMapping(value = "/company/matchingcompany/{pattern}", method = RequestMethod.GET)
	    public Iterable<CompanyDTO> getMatchingCompanies(@PathVariable("pattern") String pattern)throws Exception
	    {
	    	Iterable<CompanyDTO> companyDTO=companyService.getMatchingCompanies(pattern);
	    	return companyDTO;
	    }
	    @RequestMapping(value="/company/companyipo/{company_name}",method = RequestMethod.GET)
	    public  IpoDTO getCompanyIpoDetails(@PathVariable String company_name) throws Exception
	    {
	    	IpoDTO ipoDTO=companyService.getCompanyIpoDetails(company_name);
	    	return ipoDTO;
	    }
}
