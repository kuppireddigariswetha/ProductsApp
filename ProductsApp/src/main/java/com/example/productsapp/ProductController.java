package com.example.productsapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.productsapp.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	 @Autowired
	    private ProductsRepository productRepository;
	 
	 @Autowired
	    private SubProductRepository subProductRepository;
	 
	 
	 
	 @PostMapping("/products")
	    public Products createProduct(@RequestBody Products product) {
	        return productRepository.save(product);
	    }
	 
	 @PostMapping("/{productName}/subproducts")
	    public SubProducts createProduct(@PathVariable (value="productName") String productName,@RequestBody SubProducts subProduct) {
			 subProduct.setProductName( productRepository.findByName(productName));
			 subProduct.setMainProductName( productRepository.findByName(productName).getName());
		     return subProductRepository.save(subProduct); 
		 
	 }
	 
	 
	 @GetMapping("/{productName}/subproducts")
	    public List<SubProducts> getAllCommentsByPostId(@PathVariable (value = "productName") String productName) {
	        return subProductRepository.findByMainProductName(productName);
	    }
		
	 
	 @GetMapping("/subproducts/{quan}")
	    public Map<String,Double> getAllQuan(@PathVariable (value = "quan") int quan, @RequestBody SubProducts sb) {	       
		 String productName=sb.getMainProductName();
		 Map<String,Double> hm=new HashMap<>();
		 for(int i=0;i<subProductRepository.findByMainProductName(productName).size();i++) {			 
			 String pn= subProductRepository.findByMainProductName(productName).get(i).getSubName();
			 Double d= subProductRepository.findByMainProductName(productName).get(i).getSubCost()*quan; 
			 hm.put(pn,d);
		 }
		return hm;
	    }
		
	    
}
