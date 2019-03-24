package com.app.estore.framework.services.api;

import com.app.estore.framework.model.Product;

/**
 * Interface to convert different Product structure into resultant product
 * 
 * @author Siva
 */
public interface ProductAdapterIntf {
	
	/**
	 * Api to convert different product representation into {@link Product} 
	 * 
	 * @return
	 */
	public Product toProduct();
}
