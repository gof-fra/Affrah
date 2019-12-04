package com.haggar.affrahbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.haggar.affrahbackend.dao.CategoryDAO;
import com.haggar.affrahbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.haggar.affrahbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
	@Test
	public void testCRUDCategory() {
		
		// add
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("Some description for Mobile");
		category.setImageUrl("Cat_1.png");
		
		assertEquals("added successfully", true, categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("Some description for Television");
		category.setImageUrl("Cat_2.png");
		
		assertEquals("added successfully", true, categoryDAO.add(category));
		
		
		// Fetched and update
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Updated successfully", true, categoryDAO.update(category));
		
		// Delete
		assertEquals("Deleted successfully", true, categoryDAO.delete(category));
		
		// Fetching the list
		assertEquals("Fetched successfully the list of category from table", 1, categoryDAO.list().size());
		
		
		
	}


}
