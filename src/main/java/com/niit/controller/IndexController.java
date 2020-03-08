package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@GetMapping(value = {"","/","/index","/home"})
	public String m1()
	{
		return "home";
	}

	@GetMapping("aboutus")
	public String m4()
	{
		return "aboutus";
	}
	
	@GetMapping("contactus")
	public String m5()
	{
		return "contactus";
	}
}
