package net.saddam.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.saddam.shoppingbackend.dao.CategoryDAO;
import net.saddam.shoppingbackend.dto.Category;

import org.springframework.stereotype.Repository;

/*
 * code by saddam
 * */

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories =new ArrayList<>();
	
	static{
		
		Category category = new Category();
		
		//addig first category 
		
		category.setId(1);
		category.setName("Televesion");
		category.setDescription("This is some description for televesion");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		
		//Second category
		
         category = new Category();
		
		category.setId(2);
		category.setName("Moblile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//third category
		
        category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		
	// enhanced for loop
		for(Category category : categories){
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}
