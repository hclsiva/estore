package com.app.estore.framework.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.estore.framework.model.Product;

/**
 * Repository for product model. It has APIs to get data from 
 * Product table. 
 * @author Sivashankar
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
