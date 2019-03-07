package com.app.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }
    
    @GetMapping(value="/products", headers="Accept=application/json")
    public List<Product> getAllDepartments() {
       return productServices.getAllProduct();
    }
}
