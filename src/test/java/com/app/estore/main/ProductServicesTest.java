package com.app.estore.main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.estore.framework.model.Product;
import com.app.estore.framework.services.api.ProductRetrievalServicesAPI;
import com.app.estore.main.EstoreApplication;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ContextConfiguration(classes=EstoreApplication.class)
public class ProductServicesTest {
	@Autowired
    private ProductRetrievalServicesAPI productServices;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void productsInDepartment() {
		List products = productServices.getProductsInDepartment(1);
		assertNotNull(products);
	}
	
	@Test
	public void findProduct() {
		Product product = productServices.getProductInformation(1);
		assertEquals(product.getId(), 1);
	}
	
	@Test
	public void productsInCategory() {
		List products = productServices.getProductsInCategory(1);
		assertNotNull(products);
	}
	@Test
	public void productsWithAttributes() {
		List products = productServices.getProductsWithAttributes("1,12,13");
		assertNotNull(products);
	}
}
