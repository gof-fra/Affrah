package com.haggar.affrahbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haggar.affrahbackend.dao.CategoryDAO;
import com.haggar.affrahbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		// adding first category
		category.setId(1);
		category.setName("Tablet");
		category.setDescription("Some description for tablet");
		category.setImageUrl("CAT_1.png");
		
		categories.add(category);
		
		
		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Power bank");
		category.setDescription("Some description for power bank");
		category.setImageUrl("CAT_2.png");
		
		categories.add(category);
		
		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Printer");
		category.setDescription("Some description for printer");
		category.setImageUrl("CAT_3.png");
		
		categories.add(category);
		
		// adding fourth category
		category = new Category();
		category.setId(4);
		category.setName("Laptop");
		category.setDescription("Some description for computer");
		category.setImageUrl("CAT_4.png");
		
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {		
		// loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
		}		
		return null;
	}



}
