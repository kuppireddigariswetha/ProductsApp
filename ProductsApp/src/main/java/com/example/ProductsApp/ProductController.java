package com.example.ProductsApp;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
	 
	 
	 
	 @PostMapping("/posts")
	    public Products createProduct(@RequestBody Products product) {
		 
	        return productRepository.save(product);
	    }
	 
	 @PostMapping("/{productName}/subposts")
	    public SubProducts createProduct(@PathVariable (value="productName") String productName,@RequestBody SubProducts subProduct) {
	
			 subProduct.setProductName( productRepository.findByName(productName));
			 subProduct.setMainProductName( productRepository.findByName(productName).getName());
		 return subProductRepository.save(subProduct);
		 
	 }
	 
	 @GetMapping("/{productName}/subposts")
	    public List<SubProducts> getAllCommentsByPostId(@PathVariable (value = "productName") String productName) {
	        return subProductRepository.findByMainProductName(productName);
	    }
		
	 
	 @GetMapping("/subposts/{quan}")
	    public HashMap<String,Double > getAllQuan(@PathVariable (value = "quan") int quan, @RequestBody SubProducts sb) {
	       
		 String productName=sb.getMainProductName();
		 HashMap<String,Double > hm=new HashMap<String,Double> ();
		 for(int i=0;i<subProductRepository.findByMainProductName(productName).size();i++) {
			 
			 String pn= subProductRepository.findByMainProductName(productName).get(i).getSubName();
			 Double d= subProductRepository.findByMainProductName(productName).get(i).getSubCost()*quan;
			 
			 hm.put(pn,d);
			
		 }
		
		return hm;
	    }
		
	    
}
