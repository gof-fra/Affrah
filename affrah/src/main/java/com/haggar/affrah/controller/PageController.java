package com.haggar.affrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		
		return mv;
	}
	
	@RequestMapping(value = {"/electronic1"})
	public ModelAndView electronic1() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product");
		mv.addObject("userClickCat1", true);
		
		return mv;
	}
	
	@RequestMapping(value = {"/electronic2"})
	public ModelAndView electronic2() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product");
		mv.addObject("userClickCat2", true);
		
		return mv;
	}
	
	@RequestMapping(value = {"/product1"})
	public ModelAndView product1() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct1", true);
		
		return mv;
	}
	
	
}
