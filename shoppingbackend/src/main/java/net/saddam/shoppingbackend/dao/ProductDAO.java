package net.saddam.shoppingbackend.dao;

import java.util.List;

import net.saddam.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	//For the single product
	Product get(int productId);
	
	//List of product
	List<Product> list();
	
	boolean add(Product product);
	
	boolean update(Product product);
	
	boolean delete(Product product);
	
	
	//business methods
	
	List<Product> listActiveProducts();
	
	List<Product> listActiveProductsByCategory(int categoryId);
	
	List<Product> getLatestActiveProducts(int count);

	
	

}
