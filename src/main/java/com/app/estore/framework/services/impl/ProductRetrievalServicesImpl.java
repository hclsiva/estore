package com.app.estore.framework.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.estore.framework.cache.ProductCache;
import com.app.estore.framework.model.Product;
import com.app.estore.framework.services.api.ProductRetrievalServicesAPI;

@Component
public class ProductRetrievalServicesImpl implements ProductRetrievalServicesAPI {

    @Autowired
    private ProductCache productCache = null;
    
    @Override
    public List<Product> getAllProduct() {        
        return productCache.findAll();
    }

}
