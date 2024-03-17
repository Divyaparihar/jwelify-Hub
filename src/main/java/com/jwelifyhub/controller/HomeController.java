package com.jwelifyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jwelifyhub.model.Category;
import com.jwelifyhub.service.CategoryService;
import com.jwelifyhub.service.ProductService;

@Controller
public class HomeController {


	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/", "/home"})
	public String home(Model model) {
//		model.addAttribute("cartCount", GlobalData.cart.size());
//		model.addAttribute("cartCount", ((List<Category>) GlobalData.cart1).size());
		return "index";
	}
	
	@GetMapping({"/shop"})
	public String shop(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProduct());
//		model.addAttribute("cartCount", GlobalData.cart.size());
//		model.addAttribute("cartCount", ((List<Category>) GlobalData.cart1).size());
		return "shop";
	}
	
	
	@GetMapping({"/shop/category/{id}"})
	public String shopByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
//      model.addAttribute("cartCount", ((List<Category>) GlobalData.cart1).size());
		return "shop";
	}
	
	@GetMapping({"/shop/viewproduct/{id}"})
	public String viewProduct(Model model, @PathVariable int id) {
		model.addAttribute("product", productService.getProductById(id).get());
//      model.addAttribute("cartCount", ((List<Category>) GlobalData.cart1).size());
		return "viewProduct";
	}
}
