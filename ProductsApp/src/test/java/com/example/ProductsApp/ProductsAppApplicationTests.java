package com.example.ProductsApp;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.productsapp.Products;
import com.example.productsapp.ProductsAppApplication;
import com.example.productsapp.ProductsRepository;
import com.example.productsapp.SubProductRepository;
import com.example.productsapp.SubProducts;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
		  ProductsAppApplication.class, 
		  ProductJpaConfig.class})
@ActiveProfiles("test")
@Transactional
class ProductsAppApplicationTests {

	   @Resource
	    private ProductsRepository productsRepository;
	     
	   @Resource
	   private SubProductRepository subProductsRepository;
	   
	    @Test
	    public void givenProduct_whenSave_thenGetOk() {
	       Products p=new Products();
	       p.setName("Samsung");
	       p.setCost(100000.00);
	       productsRepository.save(p);  
	       Products p1 = productsRepository.findByName("Samsung");
	       assertEquals("Samsung", p1.getName());
	    }

	    
	    @Test
	    public void givenSubProduct__whenSave_thenGetOk() {
	    
	    	SubProducts sb=new SubProducts();
	    	sb.setSubName("Samsungi6");
	    	sb.setSubCost(2000.00);
	    	sb.setMainProductName("Samsung");
	    	SubProducts sb1=subProductsRepository.save(sb);
	    	assertEquals("Samsungi6",sb1.getSubName());
	    	
	    }
	    
	    
	    
}
