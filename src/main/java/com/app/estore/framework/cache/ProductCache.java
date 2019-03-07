package com.app.estore.framework.cache;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<Product> findAll(){
        Iterable<Product> productIter = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();
        for(Product Product : productIter) {
            productList.add(Product);
        }
        return productList;
    }
}
