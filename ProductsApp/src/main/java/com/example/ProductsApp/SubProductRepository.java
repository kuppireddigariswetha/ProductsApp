package com.example.ProductsApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.example.ProductsApp.SubProducts;
import java.util.List;
import java.util.Optional;
@Repository
public interface SubProductRepository extends CrudRepository<SubProducts, Integer>{

	List<SubProducts> findByMainProductName(String productName);

}
