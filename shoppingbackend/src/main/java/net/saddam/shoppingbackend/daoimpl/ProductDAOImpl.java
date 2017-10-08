package net.saddam.shoppingbackend.daoimpl;

import java.util.List;

import net.saddam.shoppingbackend.dao.ProductDAO;
import net.saddam.shoppingbackend.dto.Product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Product get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

}


/*
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	 * Single Product
	 * 
	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		
		try{
			
			return sessionFactory
					.getCurrentSession()
					   .get(Product.class,Integer.valueOf(productId));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}

	
	
	
	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery("FROM Product" , Product.class)
				      .getResultList();
	}
	
	
	 * Insert
	 * 
	

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
		
		
	}

	*//**
	 * Update
	 * **//*
	@Override
	public boolean update(Product product) {
		try {
			// add the category to the database table
			sessionFactory
			 .getCurrentSession()
			    .update(product);

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			// add the Product to the database table
			//sessionFactory.getCurrentSession().update(product);

			return this.update(product);

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	*//***
	 * 
	 * list of the all Active product from product table
	 * *//*
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery(selectActiveProducts, Product.class)
				      .setParameter("active", true)
				         .getResultList();
	}
	
	
	*//**
	 * 
	 * List of Active product by this category
	 * 
	 * ***//*
	
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryID = :categoryID";
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery(selectActiveProductsByCategory, Product.class)
				      .setParameter("active", true)
				        .setParameter("categoryId",categoryId)
				         .getResultList();
	}
	
	*//**
	 *  Get the latest active product
	 * 
	 * *//*

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
				   .createQuery("FROM PRODUCT WHERE active = :active ORDER BY id ", Product.class)
				      .setParameter("active", true)
				        .setFirstResult(0)
				         .setMaxResults(count)
				           .getResultList();
	}

}
*/



