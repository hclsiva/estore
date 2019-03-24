package com.app.estore.framework.services.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.estore.framework.cache.ProductCache;
import com.app.estore.framework.model.Product;
import com.app.estore.framework.model.ResultProduct;
import com.app.estore.framework.services.api.ProductRetrievalServicesAPI;

@Component
public class ProductRetrievalServicesImpl implements ProductRetrievalServicesAPI {

    @Autowired
    private ProductCache productCache = null;
    
    @PersistenceContext
    private EntityManager entityManager = null;
    
    @Override
    public List<Product> getAllProduct() {        
        return productCache.findAll();
    }
    
	@Override
	public List<ResultProduct> getProductsInDepartment(int departmentId) {
		int count = -1;
    	StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("countProductsOnDepartment");    	
    	
    	query.setParameter(1, departmentId);
    	query.execute();
    	
    	List resultList = query.getResultList();
    	if(Objects.nonNull(resultList) && resultList.size() > 0) {
    		count = Integer.valueOf(resultList.get(0).toString());
    	}
		
		List<ResultProduct> productList = null;
		query = entityManager.createNamedStoredProcedureQuery("getProductsInDepartment");    	
    	
    	query.setParameter("inDepartmentId", departmentId);
    	query.setParameter("inShortProductDescriptionLength", 100);
    	query.setParameter("inProductsPerPage", count);
    	query.setParameter("inStartItem", 0);
    	
    	query.execute();
    	productList = query.getResultList();
    	
    	return productList;
	}

	@Override
	public Product getProductInformation(int ProductId) {
		
		return productCache.findById(ProductId);
	}
	
	@Override
	public List<ResultProduct> getProductsInCategory(int categoryId) {
		int count = -1;
		List<ResultProduct> productList = null;
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("countProductsOnCategory");    	
    	
    	query.setParameter(1, categoryId);
    	query.execute();
    	
    	List resultList = query.getResultList();
    	if(Objects.nonNull(resultList) && resultList.size() > 0) {
    		count = Integer.valueOf(resultList.get(0).toString());
    	}
		
		
		query = entityManager.createNamedStoredProcedureQuery("getProductsInCategory");    	
    	
    	query.setParameter("inCategoryId", categoryId);
    	query.setParameter("inShortProductDescriptionLength", 100);
    	query.setParameter("inProductsPerPage", count);
    	query.setParameter("inStartItem", 0);
    	
    	query.execute();
    	productList = query.getResultList();
    	
    	return productList;
	}

	@Override
	public List<ResultProduct> getProductsWithAttributes(String attributesAsCSV) {
		
		List<ResultProduct> productList = null;
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getProductsWithAttributes");    	
    	
    	query.setParameter("cAttributes", attributesAsCSV);
    	query.setParameter("inShortProductDescriptionLength", 100);
    	   	
    	query.execute();
    	productList = query.getResultList();
    	
    	return productList;
	}
}
