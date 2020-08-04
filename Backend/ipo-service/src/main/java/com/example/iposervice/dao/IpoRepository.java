package com.example.iposervice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.iposervice.dao.entities.IpoEntity;
@Repository
public interface IpoRepository extends CrudRepository<IpoEntity,Integer>  {
	IpoEntity findByCompanyName(String company_name);

}
