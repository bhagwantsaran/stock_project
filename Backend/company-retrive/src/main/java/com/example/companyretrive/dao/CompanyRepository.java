package com.example.companyretrive.dao;


import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.companyretrive.dao.entities.CompanyEntity;
import com.example.companyretrive.dao.entities.StockPriceEntity;



@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer>{
	public CompanyEntity findByCompanyName(String companyName);
	Iterable<CompanyEntity> findByCompanyNameContaining(String pattern);
	@Query(value="select currentprice from stock where companyid=?1 and date between ?2 and ?3  and stockexchange=?4  order by date desc,time desc limit 1;", nativeQuery = true)
	float findByIdAndDateBetweenAndStockExchange(long id,Date fromDate,Date toDate,String stockExchange);
	

}
