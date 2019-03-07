package com.app.estore.framework.services.api;

import java.util.List;

import com.app.estore.framework.model.Product;

/**
 * Interface for having retrieval Apis for the product.
 * 
 * @return
 */
public interface ProductRetrievalServicesAPI {

    /**
     * Api to get list of all product available
     * 
     * @return
     */
    public List<Product> getAllProduct();
}
