package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Pizza;
import com.niit.service.PizzaService;

@Controller
@RequestMapping("/pizza")
public class PizzaController 
{
	@Autowired
	PizzaService pizzaService;
	
	@GetMapping("/add")
	public String m1(ModelMap map)
	{
		map.addAttribute("pizza",new Pizza());
		return "addpizza";
	}
	
	@PostMapping("/add")
	public String m3(@ModelAttribute("pizza") Pizza pizza)
	{
		pizzaService.addPizza(pizza);
		return "redirect:/";
	}
	
	@GetMapping("/display")
	public String m2()
	{
		return "displaypizza";
	}
}
