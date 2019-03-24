package com.app.estore.framework.filter.model;

import java.util.List;

import com.app.estore.framework.model.Product;

/**
 * Bean to hold the result of filtered/Searched Products
 * 
 * @author Sivashankar
 *
 */
public class FilteredProduct {

    private int totalCount = 0;
    private List<Product> products = null;    
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
