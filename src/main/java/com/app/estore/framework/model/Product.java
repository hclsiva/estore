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

@Entity
@Table(name = "PRODUCT")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "countProductsOnDepartment", procedureName = "catalog_count_products_on_department", parameters = {
				@StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) }),
		@NamedStoredProcedureQuery(name = "countProductsOnCategory", procedureName = "catalog_count_products_in_category", parameters = {
				@StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) }) })
public class Product {

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Product)) {
			return false;
		}

		Product that = (Product) o;
		return this.id == that.id;
	}

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

	@Column(name = "image")
	private String image;

	@Column(name = "image_2")
	private String image2;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "display")
	private int display;
}
