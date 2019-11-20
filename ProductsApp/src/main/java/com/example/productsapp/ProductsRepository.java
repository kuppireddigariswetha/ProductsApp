package com.example.productsapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>{

	Products findByName(String name);
	
}
