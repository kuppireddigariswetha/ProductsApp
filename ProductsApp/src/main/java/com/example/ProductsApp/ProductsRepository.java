package com.example.ProductsApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.example.ProductsApp.Products;
import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>{

	Products findByName(String name);
	
}
