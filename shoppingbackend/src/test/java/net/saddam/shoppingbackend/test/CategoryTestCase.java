package net.saddam.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.saddam.shoppingbackend.dao.CategoryDAO;
import net.saddam.shoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	
	
	private static AnnotationConfigApplicationContext context;//access the bean
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.saddam.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	
	/*@Test
	public void testAddCategory(){
		
		category  = new Category();
		
		category.setName("Televesion");
		category.setDescription("This is some description for Televesion");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully assed a category inside the table",true,categoryDAO.add(category));
		
		
	}*/
	
	/*@Test
	public void testGetCategory(){
		//get the category by its id
		
		category = categoryDAO.get(34);
		assertEquals("Successfully fetch a single category from the table","Televesion",category.getName());
		
	}*/
	
	
	/*@Test
	public void testUpdateCategory(){
		//get the category by its id
		
		category = categoryDAO.get(34);
		
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table",true,categoryDAO.update(category));
		
	}*/
	/*@Test
	public void testDeleteCategory(){
		//get the category by its id
		
		category = categoryDAO.get(34);
		
		category.setName("TV");
		assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testListCategory(){
		//get the category by its id
		
		category = categoryDAO.get(34);
		
		category.setName("TV");
		assertEquals("Successfully fatch the list of category from the table",3,categoryDAO.list().size());
		
	}*/
	
	@Test
	public void testCRUDCategory(){
		
       //Add operaion
		
		category  = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully assed a category inside the table",true,categoryDAO.add(category));
		
         category  = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully assed a category inside the table",true,categoryDAO.add(category));
		
		
			//Fatching and updation the category
			
			category = categoryDAO.get(2);
			
			category.setName("TV");
			assertEquals("Successfully updated a single category in the table",true,categoryDAO.update(category));
			
		//Delete the category
			
			assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
			
		//	fetching the llist
			assertEquals("Successfully fatch the list of category from the table",1,categoryDAO.list().size());
			
	}
	
	
	
	
	
	
}
