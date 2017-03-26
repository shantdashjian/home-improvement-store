package com.sd.homeimprovementstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.homeimprovementstore.data.Category;
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

	@RequestMapping(value = "displayProduct.do", method = RequestMethod.GET)
	public ModelAndView getProductByID(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayproduct");
		System.out.println("product" + id);
		Product product = dao.getProductById(id);
		mv.addObject("product", product);
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

	@RequestMapping(value = "addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addproduct");
		List<Category> categories = dao.getCategories();
		mv.addObject("categories", categories);
		return mv;
	}
	@RequestMapping(value = "createProduct.do", method = RequestMethod.POST)
	public ModelAndView createProduct(Product product, Stock stock) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productadded");
		mv.addObject("addedProduct", dao.addProduct(product, stock));
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
		mv.setViewName("productdeleted");
		String response = dao.deleteProduct(id);
		mv.addObject("response", response);
		return mv;
	}

}