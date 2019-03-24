package com.app.estore.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.estore.controller.helper.ProductRetriever;
import com.app.estore.framework.filter.model.FilteredProduct;
import com.app.estore.framework.model.Product;
import com.app.estore.framework.services.api.ProductRetrievalServicesAPI;

/**
 * @author Sivashankar
 * 
 * Rest class to work with product model
 *
 */
@RestController
@Component
public class ProductController {
    @Autowired
    private ProductRetrievalServicesAPI productServices;
    
    @Autowired
    private ProductRetriever productRetriever;
    
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }
    
    @GetMapping(value="/products", headers="Accept=application/json")
    public List<Product> getAllDepartments() {
       return productServices.getAllProduct();
    }

    @RequestMapping(value="/pagingfilter")
    public FilteredProduct getFilteredProduct(@RequestParam(name="filter") String filter,
    											@RequestParam(name="page") String pageNo,
    											@RequestParam(name="start") String start,
    											@RequestParam(name="limit") String limit) {
    	log.info("Incoming filter = " + filter);
    	 
		List<Product> products = productRetriever.retrieveProductMatching(filter);
		FilteredProduct filteredProduct = new FilteredProduct();
		if (Objects.nonNull(products)) {
			filteredProduct.setProducts(products);
			filteredProduct.setTotalCount(products.size());
		}       
		return filteredProduct;
    }
    @RequestMapping(value="/filter")
    public FilteredProduct getFilteredProduct(@RequestParam String filter) {
    	log.info("Incoming filter = " + filter);
    	 
		List<Product> products = productRetriever.retrieveProductMatching(filter);
		FilteredProduct filteredProduct = new FilteredProduct();
		if (Objects.nonNull(products)) {
			filteredProduct.setProducts(products);
			filteredProduct.setTotalCount(products.size());
		}       
		return filteredProduct;
    }
}
