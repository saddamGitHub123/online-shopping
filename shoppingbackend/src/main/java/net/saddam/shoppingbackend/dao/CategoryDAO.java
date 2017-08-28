package net.saddam.shoppingbackend.dao;

import java.util.List;

import net.saddam.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list();
	
	//Abstract method
	Category get(int id);

}
