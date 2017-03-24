package com.sd.homeimprovementstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.homeimprovementstore.data.HomeDAO;
import com.sd.homeimprovementstore.data.Product;

public class HomeController {

	@Autowired
	private HomeDAO dao;
	
	@RequestMapping(value = "home.do")
	public String home() {
		return ("home");
	}

	@RequestMapping(value = "getProduct.do", method=RequestMethod.GET)
	public ModelAndView getProductByID(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product product = dao.getProductById(id);
		mv.addObject("film", product);
		return mv;
	}
	
	@RequestMapping(value = "getInventory.do", method=RequestMethod.GET)
	public ModelAndView getInventory() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Product> inventory = dao.getInventory();
		mv.addObject("inventory", inventory);
		return mv;
	}
	
	@RequestMapping(value = "addProduct.do", method=RequestMethod.POST)
	public ModelAndView addProduct(Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product returnedProduct = dao.addProduct(product);
		mv.addObject("returnedProduct", returnedProduct);
		return mv;
	}
	
	@RequestMapping(value = "editProduct.do", method=RequestMethod.POST)
	public ModelAndView editProduct(Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product returnedProduct = dao.editProduct(product);
		mv.addObject("returnedProduct", returnedProduct);
		return mv;
	}
	
	@RequestMapping(value = "deleteProduct.do", method=RequestMethod.POST)
	public ModelAndView deleteProduct(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		String response = dao.deleteProduct(id);
		mv.addObject("response", response);
		return mv;
	}
	
	@RequestMapping(value = "getStock.do", method=RequestMethod.GET)
	public ModelAndView getStockById(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product product = dao.getProductById(id);
		int productStock = dao.getStockById(id);
		mv.addObject("amount", productStock);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping(value = "editStock.do", method=RequestMethod.POST)
	public ModelAndView updateStockById(Integer id, Integer amount) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product product = dao.getProductById(id);
		String response = dao.updateStockById(id, amount);
		mv.addObject("response", response);
		mv.addObject("product", product);
		return mv;
	}
}