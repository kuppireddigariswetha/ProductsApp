package com.example.ProductsApp;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class ProductsAppTest extends ProductsAppApplicationTests{
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	 private ProductsRepository productRepository;
	
	@Test
	public void testPosts(){
		
		Products product=new Products();
		product.setId(1);
		product.setName("Samsungg");
		product.setCost(10000.00);
		LocalDate date1 = LocalDate.of(2019, 1, 13);
		LocalDate date2 = LocalDate.of(2020, 1, 13);
	    product.setFromDate( date1);
	    product.setFromDate( date2);
	    
	    productController.createProduct(product);
	    assertEquals("Samsungg",productRepository.findByName("Samsungg"));
	}
	
}
