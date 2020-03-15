package com.niit.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import com.niit.model.Pizza;
import com.niit.model.User;
import com.niit.service.PizzaService;
import com.niit.service.UserService;

@Controller
@RequestMapping("/buy")
public class BuyController
{
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index/{id}")
	public void m1(@PathVariable("id") int pizzaid,HttpServletResponse resp)
	{
		Pizza pizza=pizzaService.displayPizzaById(pizzaid);
	
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=null;
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  u=userService.displayUserByName(user.getUsername());
		}
		
		  try 
	       {
	           ApiContext context = ApiContext.create("test_BaRDDGvbDNj0ZcudrrjqHnGKHtQqkC6iiDF", "test_5qikY6U2ikPAqCCcje7IZjXDG7yHMKG8nnLnibJXaZHiO8kmW8ayuXFyxGwOzqqc4u0PhrkqG4jfJ3RjXGEefqSdIwnnKfPiCvegi0qmjM62DX97ZHNFIWmqcyV", ApiContext.Mode.TEST);
	           Instamojo api = new InstamojoImpl(context);

	           PaymentOrder order = new PaymentOrder();
	           order.setName(u.getUsername());
	           order.setEmail(u.getEmail());
	           order.setPhone("7977518582");
	           order.setCurrency("INR");
	           order.setAmount((double)pizza.getPrice());
	           order.setDescription(pizza.getPizzaName());
	           order.setRedirectUrl("https://www.google.com");
	           order.setWebhookUrl("https://www.google.com");
	           order.setTransactionId(UUID.randomUUID().toString());

	           PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
	           resp.sendRedirect(paymentOrderResponse.getPaymentOptions().getPaymentUrl());
	       }
	       catch (Exception e) 
	       {
	           System.out.println(e);
	       }
	}
}
