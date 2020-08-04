package com.example.uploadservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadservice.model.StockPriceEntity;


@Repository
public interface UserRepository extends CrudRepository<StockPriceEntity, Long> {

}
