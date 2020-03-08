package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.User;
import com.niit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String m1(ModelMap map)
	{
		map.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/add")
	public String m1(@ModelAttribute("user") User user)
	{
		userService.addUser(user);
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String m2()
	{
		return "login";
	}
	
}
