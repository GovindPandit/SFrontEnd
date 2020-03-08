package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String m2(ModelMap map)
	{
		map.addAttribute("pizza",pizzaService.displayAllPizza());
		return "displaypizza";
	}
	
	@GetMapping("/display/{id}")
	public String m3(@PathVariable("id") int pizzaid,ModelMap map)
	{
		map.addAttribute("pizza",pizzaService.displayPizzaById(pizzaid));
		return "pizza";
	}
	
	@GetMapping("/edit/{id}")
	public String m4(@PathVariable("id") int pizzaid,ModelMap map)
	{
		map.addAttribute("p",pizzaService.displayPizzaById(pizzaid));
		return "addpizza";
	}
	
	
	@PostMapping("/update")
	public String m4(@ModelAttribute("p") Pizza pizza)
	{
		pizzaService.updatePizza(pizza);
		return "redirect:/pizza/display";
	}
	
	@GetMapping("/delete/{id}")
	public String m5(@PathVariable("id") int pizzaid)
	{
		pizzaService.deletePizza(pizzaid);
		return "redirect:/pizza/display";
	}
}
