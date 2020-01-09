package com.haggar.affrah.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haggar.affrah.exception.ProductNotFoundException;
import com.haggar.affrahbackend.dao.CategoryDAO;
import com.haggar.affrahbackend.dao.ProductDAO;
import com.haggar.affrahbackend.dto.Category;
import com.haggar.affrahbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);		
		return mv;
	}
	
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {	
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/help"})
	public ModelAndView help() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "404");
		mv.addObject("userClickHelp", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/single"})
	public ModelAndView single() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "single");
		mv.addObject("userClickSingle", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/checkout"})
	public ModelAndView checkout() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", " My Card ");
		mv.addObject("userClickCheckout", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/payment"})
	public ModelAndView payment() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", " Payment ");
		mv.addObject("userClickPayment", true);		
		return mv;
	}    
	
	@RequestMapping(value = {"/footer1"})
	public ModelAndView products1() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Products");
		mv.addObject("userClickFooter1", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/footer2"})
	public ModelAndView products2() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Products");
		mv.addObject("userClickFooter2", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/footer3"})
	public ModelAndView products3() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Products");
		mv.addObject("userClickFooter3", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView products() {		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", " Products ");
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickProducts", true);		
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/single"})
	public ModelAndView single(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("home");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// passing the list of category
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickSingle", true);		
		return mv;
	}
	
	// View single product
	@RequestMapping(value = "/show/{id}/product")
	public  ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("home");
		
		Product product = productDAO.get(id);
		
		// for product not available
		if(product==null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}
	
}
	