package com.app.estore.framework.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

import com.app.estore.framework.model.Product;
import com.app.estore.framework.repo.ProductRepository;

@Component
@CacheConfig(cacheNames = {"product"})
public class ProductCache {
    @Autowired
    private ProductRepository productRepository = null;
    
    /**
     * Api to get all products from the database. 
     * 
     * @return
     */
    public List<Product> findAll(){
        Iterable<Product> productIter = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();
        for(Product Product : productIter) {
            productList.add(Product);
        }
        return productList;
    }

    /**
     * Api to return product information for the given Id
     * 
     * @param id
     * @return
     */
    public Product findById(int id) {
    	Optional<Product> optionalResult = productRepository.findById(id);
    	if(optionalResult.isPresent())
    		return optionalResult.get();
    	return null;
    }
}
