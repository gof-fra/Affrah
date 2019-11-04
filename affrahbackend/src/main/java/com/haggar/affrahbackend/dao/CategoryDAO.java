package com.haggar.affrahbackend.dao;

import java.util.List;

import com.haggar.affrahbackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	
}
