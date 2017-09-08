package net.saddam.shoppingbackend.daoimpl;

import java.util.List;

import net.saddam.shoppingbackend.dao.CategoryDAO;
import net.saddam.shoppingbackend.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * code by saddam
 * */

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories =new ArrayList<>();
	 * 
	 * static{
	 * 
	 * Category category = new Category();
	 * 
	 * //addig first category
	 * 
	 * category.setId(1); category.setName("Televesion");
	 * category.setDescription("This is some description for televesion");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * categories.add(category);
	 * 
	 * 
	 * //Second category
	 * 
	 * category = new Category();
	 * 
	 * category.setId(2); category.setName("Moblile");
	 * category.setDescription("This is some description for Mobile");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * categories.add(category);
	 * 
	 * //third category
	 * 
	 * category = new Category();
	 * 
	 * category.setId(3); category.setName("Laptop");
	 * category.setDescription("This is some description for Laptop");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * categories.add(category);
	 * 
	 * }
	 */

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	/*
	 * @saddam Getting single category base on id
	 */

	@Override
	public Category get(int id) {

		/*
		 * // enhanced for loop for(Category category : categories){
		 * if(category.getId()==id) return category; }
		 */
		return sessionFactory.getCurrentSession().get(Category.class,
				Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}
	
	/*
	 * update a single category
	 * (non-Javadoc)
	 * @see net.saddam.shoppingbackend.dao.CategoryDAO#update(net.saddam.shoppingbackend.dto.Category)
	 */

	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
