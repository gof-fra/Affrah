package com.haggar.affrahbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haggar.affrahbackend.dao.CategoryDAO;
import com.haggar.affrahbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
/*	private static List<Category> categories = new ArrayList<Category>();
	
	
	static {
		
		Category category = new Category();
		//1
		category.setId(1);
		category.setName("phone");
		category.setDescription("Some description for phone");
		category.setImageUrl("Cat_1.png");
		
		categories.add(category);
		
		//2
		category = new Category();
		
		category.setId(2);
		category.setName("printer");
		category.setDescription("Some description for printer");
		category.setImageUrl("Cat_2.png");
		
		categories.add(category);
		
		//3
		category = new Category();
		
		category.setId(3);
		category.setName("television");
		category.setDescription("Some description for television");
		category.setImageUrl("Cat_3.png");
		
		categories.add(category);
		
		
		
	}*/

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE activate = :activate";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("activate", true);

		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
	}

	@Override
	public boolean add(Category category) {
		
		try {
			
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean update(Category category) {
		try {
			
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActivate(false);
		
		try {
			
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
