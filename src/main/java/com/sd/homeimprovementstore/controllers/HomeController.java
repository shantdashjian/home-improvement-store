package com.sd.homeimprovementstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.homeimprovementstore.data.HomeDAO;
import com.sd.homeimprovementstore.data.HomeDAODBImpl;
import com.sd.homeimprovementstore.data.Product;
import com.sd.homeimprovementstore.data.Stock;

@Controller
public class HomeController {

	@Autowired
	public HomeDAO dao;

	@RequestMapping(value = "home.do")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Stock> inventory = dao.getInventory();
		mv.addObject("inventory", inventory);
		return mv;
	}

	@RequestMapping(value = "getProduct.do", method = RequestMethod.GET)
	public ModelAndView getProductByID(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product product = dao.getProductById(id);
		mv.addObject("film", product);
		return mv;
	}

	@RequestMapping(value = "getInventory.do", method = RequestMethod.GET)
	public ModelAndView getInventory() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Stock> inventory = dao.getInventory();
		mv.addObject("inventory", inventory);
		return mv;
	}

	@RequestMapping(value = "addProduct.do", method = RequestMethod.POST)
	public ModelAndView addProduct(Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product returnedProduct = dao.addProduct(product);
		mv.addObject("returnedProduct", returnedProduct);
		return mv;
	}

	@RequestMapping(value = "editProduct.do", method = RequestMethod.POST)
	public ModelAndView editProduct(Product product, Integer quantity) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Product returnedProduct = dao.editProduct(product, quantity);
		mv.addObject("returnedProduct", returnedProduct);
		return mv;
	}

	@RequestMapping(value = "deleteProduct.do", method = RequestMethod.POST)
	public ModelAndView deleteProduct(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		String response = dao.deleteProduct(id);
		mv.addObject("response", response);
		return mv;
	}

}