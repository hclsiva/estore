package com.app.estore.framework.services.api;

import java.util.List;

import com.app.estore.framework.model.Product;
import com.app.estore.framework.model.ResultProduct;

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
    
    
    /**
     * 
     * Api to get products under a department.
     * 
     * @param departmentId
     * @param productCount - number of rows to be returned
     * @return
     */
    public List<ResultProduct> getProductsInDepartment(int departmentId);
    
    /**
     * API to get product information for the given product Id
     * 
     * @param ProductId
     * @return
     */
    public Product getProductInformation(int ProductId);
    
    /**
     * Api to get products for a given category Id 
     * 
     * @param categoryId
     * @return
     */
    public List<ResultProduct> getProductsInCategory(int categoryId);
    
    /**
     * Api to get products with different given attributes
     * 
     * @param attributesAsCSV
     * @return
     */
    public List<ResultProduct> getProductsWithAttributes(String attributesAsCSV);
}
