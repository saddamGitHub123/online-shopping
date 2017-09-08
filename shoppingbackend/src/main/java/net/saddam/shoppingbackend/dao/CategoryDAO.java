package net.saddam.shoppingbackend.dao;

import java.util.List;

import net.saddam.shoppingbackend.dto.Category;

public interface CategoryDAO {
	//Abstract method
			Category get(int id);
		
			List<Category> list();
			
		    boolean add(Category category);
		    
		    boolean update(Category category);
		    
		    boolean delete(Category category);
}
