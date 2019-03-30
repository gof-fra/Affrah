package com.haggar.affrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
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
	
	@RequestMapping(value = {"/products"})
	public ModelAndView products() {
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", " Products ");
		mv.addObject("userClickProducts", true);
		
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
	
	@RequestMapping(value = {"/single"})
	public ModelAndView single() {
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", " Product ");
		mv.addObject("userClickSingle", true);
		
		return mv;
	}
	
	
}
	