package com.example.companyretrive.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.companyretrive.dao.CompanyRepository;
import com.example.companyretrive.dao.entities.CompanyEntity;
import com.example.companyretrive.dao.entities.StockPriceEntity;
import com.example.companyretrive.dto.CompanyDTO;
import com.example.companyretrive.dto.IpoDTO;
import com.example.companyretrive.dto.StockPriceDTO;
import com.example.companyretrive.ipoclient.IpoClient;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;



@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private IpoClient ipoClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Override
    public CompanyDTO getCompany(String companyName) throws Exception {
        LOGGER.info("Fetching Order details for OrderId: {}", companyName);
        CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
        CompanyDTO companyDTO = null;
        System.out.println(companyEntity);

        	ModelMapper mapper=new ModelMapper();
    	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    	    
            companyDTO = mapper.map(companyEntity,CompanyDTO.class);
            System.out.println(companyEntity);
    	    System.out.println(companyDTO);
            //LOGGER.info("yes Fetching Order details for OrderId: {}", companyId,companyDTO.getCompany_name());
       

        return companyDTO;
    }
    @Override
    public Iterable<CompanyDTO> getMatchingCompanies(String pattern)throws Exception
    {
    	List <CompanyDTO> list=new ArrayList<>();
    	Iterable<CompanyEntity> companyEntity=companyRepository.findByCompanyNameContaining(pattern);
    	ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    for(CompanyEntity entity : companyEntity) {
	    	
	    	CompanyDTO cdt=mapper.map(entity,CompanyDTO.class);
	    	list.add(cdt);
	    	
	    }
	    Iterable<CompanyDTO> companyDTO=list;
	    return companyDTO;
    	
    }
    @Override
    public IpoDTO getCompanyIpoDetails(String company_name) throws Exception
    {
    	return ipoClient.getCompanyIpoDetails(company_name);
    }
    public static Date addDays(Date date,int days)
    {
    	Calendar c=Calendar.getInstance();
		 c.setTime(date);
		 c.add(Calendar.DATE,days);
		 return new Date(c.getTimeInMillis());
    }
	@Override
	public List< Float > getStockPrice(long companyId, Date fromDate, Date toDate,int periodicity) {
    	
    	long Duration=toDate.getTime()-fromDate.getTime();
    	int days=(int) (TimeUnit.MILLISECONDS.toDays(Duration)+1);
    	List< Float >list=new ArrayList<Float>();
    	Date dt=fromDate;
    	Date dt1=fromDate;
    	int inc=days/periodicity;
    	int mod=days%periodicity;
    	for(int i=0;i<inc;i++)
    	{
    		fromDate.toLocalDate();

    			dt1=addDays(dt,periodicity-1);
    		list.add(companyRepository.findByIdAndDateBetweenAndStockExchange(companyId,dt,dt1,"BSE"));
    		dt=addDays(dt1,1);
    		
    	}
    	if(mod!=0)
    		list.add(companyRepository.findByIdAndDateBetweenAndStockExchange(companyId,dt,dt1,"BSE"));
    	
    	return list;
	    
	}
    
}
