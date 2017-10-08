package net.saddam.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.saddam.shoppingbackend.dao.ProductDAO;
import net.saddam.shoppingbackend.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;// access the bean

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.saddam.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}
/*
	@Test
	public void testCRUDProduct() {

		// Create operation

		product = new Product();

		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo Mobile phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		// product.setImageURL("CAT_1.png");

		assertEquals("Something went wrong while inserting a new product",true,productDAO.add(product));

		// Reading and updating the category

		product = productDAO.get(2);

		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record",
				true, productDAO.update(product));

		// Delete the category

		assertEquals(
				"Something went wrong while deleting the existing record!",
				true, productDAO.delete(product));

		// fetching the list
		assertEquals(
				"Something went wrong while fetching the list of products", 6,
				productDAO.list().size());

	}*/
	
	@Test
	public void testListActiveProducts(){
		
		
		assertEquals(
				"Something went wrong while fetching the list of products", 5,
				productDAO.listActiveProducts().size());
	
		
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		
		
		assertEquals(
				"Something went wrong while fetching the list of products", 3,
				productDAO.listActiveProductsByCategory(3).size());
		
		
		assertEquals(
				"Something went wrong while fetching the list of products", 2,
				productDAO.listActiveProductsByCategory(1).size());
	
		
	}
	
	@Test
	public void testGetLatestActiveProduct(){
		
		
		assertEquals(
				"Something went wrong while fetching the list of products", 3,
				productDAO.getLatestActiveProducts(3).size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}