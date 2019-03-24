package com.app.estore.controller.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.estore.framework.model.Product;
import com.app.estore.framework.model.ResultProduct;
import com.app.estore.framework.services.api.ProductRetrievalServicesAPI;

@Component
public final class ProductRetriever {
	@Autowired
	private ProductRetrievalServicesAPI productServices;
	private static final Logger log = LoggerFactory.getLogger(ProductRetriever.class);

	public ProductRetriever() {
	}

	public List<Product> retrieveProductMatching(String filterCondition) {
		FilterParser parser = new FilterParser(filterCondition);
		parser.parse();
		Set<ResultProduct> productSet = new HashSet<ResultProduct>();
		if(parser.getDepartments() != null) {
			productSet.addAll(getProductsInDepartment(parser.getDepartments()));
		}
		if(parser.getCategories() != null) {
			productSet.addAll(getProductsInCategories(parser.getCategories()));
		}
		if(parser.getAttributeCsv() != null) {
			productSet.addAll(getProductsWithAttributeValues(parser.getAttributeCsv()));
		}
		List<Product> productList = null;
		if(productSet.size() >0) {
			productList = convert(productSet);
		} else {
			productList = productServices.getAllProduct();
		}
		return productList;		
	}

	private Set<ResultProduct> getProductsInDepartment(int[] departments) {
		Set<ResultProduct> productSet = new HashSet<ResultProduct>();
		for (int departmentId : departments) {
			productSet.addAll(productServices.getProductsInDepartment(departmentId));
		}
		return productSet;
	}

	private Set<ResultProduct> getProductsInCategories(int[] categories) {
		Set<ResultProduct> productSet = new HashSet<ResultProduct>();
		for (int categoryId : categories) {
			productSet.addAll(productServices.getProductsInDepartment(categoryId));
		}
		return productSet;
	}

	private Set<ResultProduct> getProductsWithAttributeValues(String attributeCsv) {
		Set<ResultProduct> productSet = new HashSet<ResultProduct>();
		productSet.addAll(productServices.getProductsWithAttributes(attributeCsv));
		return productSet;
	}
	private List<Product> convert(Set<ResultProduct> resultProductSet){
		List<Product> products = new ArrayList<Product>();
		for(ResultProduct result : resultProductSet) {
			products.add(result.toProduct());
		}
		return products;
	}
}
