package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.CartItem;
import com.niit.model.Pizza;
import com.niit.model.User;
import com.niit.service.CartService;
import com.niit.service.PizzaService;
import com.niit.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	
	
	@RequestMapping("/add/{pizzaid}")
	public String m1(@PathVariable("pizzaid") int pizzaid)
	{
		Pizza pizza=pizzaService.displayPizzaById(pizzaid);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  User u=userService.displayUserByName(user.getUsername());
		  
		  CartItem cItem=new CartItem();
		  cItem.setPizza(pizza);
		  cItem.setUser(u);
		  
		  cartService.addCartItem(cItem);
		  
		}
		
		return "redirect:/cart/display";
		
	}
	
	@RequestMapping("/display")
	public String m2(ModelMap map)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  User u=userService.displayUserByName(user.getUsername());
		  
		  map.addAttribute("cartItems",u.getCartItems());
		}
		return "cartitems";
	}
	
	@RequestMapping("/display/{id}")
	public String m2(@PathVariable("id") int cartitemid,ModelMap map)
	{
		
		map.addAttribute("cartItem",cartService.displayCartById(cartitemid));
		return "cartitem";
	}
}
