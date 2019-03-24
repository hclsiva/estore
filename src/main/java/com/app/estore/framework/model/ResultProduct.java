package com.app.estore.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.app.estore.framework.services.api.ProductAdapterIntf;

@Entity
@Table(name = "PRODUCT")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getProductsInDepartment", procedureName = "catalog_get_products_on_department", resultClasses = ResultProduct.class, parameters = {
				@StoredProcedureParameter(name = "inDepartmentId", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inShortProductDescriptionLength", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inProductsPerPage", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inStartItem", type = Integer.class, mode = ParameterMode.IN) }),
		@NamedStoredProcedureQuery(name = "getProductsInCategory", procedureName = "catalog_get_products_in_category", resultClasses = ResultProduct.class, parameters = {
				@StoredProcedureParameter(name = "inCategoryId", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inShortProductDescriptionLength", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inProductsPerPage", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inStartItem", type = Integer.class, mode = ParameterMode.IN) }),
		@NamedStoredProcedureQuery(name = "getProductsWithAttributes", procedureName = "catalog_get_products_with_attributes", resultClasses = ResultProduct.class, parameters = {
				@StoredProcedureParameter(name = "cAttributes", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "inShortProductDescriptionLength", type = Integer.class, mode = ParameterMode.IN) }),

})
public class ResultProduct implements ProductAdapterIntf, Comparable<ResultProduct> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private float price;

	@Column(name = "discounted_price")
	private float discountedPrice;

	@Column(name = "thumbnail")
	private String thumbnail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof ResultProduct)) {
			return false;
		}

		ResultProduct that = (ResultProduct) o;
		return this.id == that.id;
	}

	@Override
	public Product toProduct() {
		Product product = new Product();
		product.setId(this.getId());
		product.setDescription(this.getDescription());
		product.setDiscountedPrice(this.getDiscountedPrice());
		product.setName(this.getName());
		product.setPrice(this.getPrice());
		product.setThumbnail(this.getThumbnail());
		return product;
	}

	@Override
	public int compareTo(ResultProduct that) {
		if(this.equals(that)){
			return 0;
		}else if(this.id > that.id) {
			return 1;
		}else {
			return -1;
		}
		
	}

}
