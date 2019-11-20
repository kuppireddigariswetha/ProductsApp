package com.example.productsapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubProductRepository extends CrudRepository<SubProducts, Integer>{

	List<SubProducts> findByMainProductName(String productName);

}
