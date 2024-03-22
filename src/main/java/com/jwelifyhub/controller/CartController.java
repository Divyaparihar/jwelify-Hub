package com.jwelifyhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jwelifyhub.global.GlobalData;
import com.jwelifyhub.model.Products;
import com.jwelifyhub.service.ProductService;

@Controller
public class CartController {

   @Autowired
   ProductService productService;
   
   @GetMapping("/addToCart/{id}")
   public String addToCart(@PathVariable int id) {
       GlobalData.cart.add(productService.getProductById(id).get());
       return "redirect:/shop";
   }
    
   @GetMapping("/cart")
   public String cartGet(Model model) {
       model.addAttribute("cartCount", GlobalData.cart.size());
//     model.addAttribute("total", calculateTotalPrice());
       model.addAttribute("cart", GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());
       return "cart"; // Assuming there is a corresponding cart view
   }
   
//   @GetMapping("/cart/removeItem/{index}")
//   public String cartItemRemove(@PathVariable int index) {
//       if (index >= 0 && index < GlobalData.cart.size()) {
//           GlobalData.cart.remove(index);
//       }
//       
//       return "redirect:/cart";
//   }
//	
//   @GetMapping("/checkout")
//   public String checkout(Model model) {
//       model.addAttribute("total", calculateTotalPrice());
//       return "checkout"; // Assuming there is a corresponding checkout view
//   }
//   
//   private double calculateTotalPrice() {
//	   return GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
//   }
}
