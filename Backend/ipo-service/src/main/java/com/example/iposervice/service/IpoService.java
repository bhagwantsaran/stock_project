package com.example.iposervice.service;

import com.example.iposervice.dto.IpoDTO;

public interface IpoService {
	IpoDTO getCompanyIpoDetails(String company_name)throws Exception;
}
