package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String m3(@ModelAttribute("pizza") Pizza pizza,@RequestParam("pizzaimage") MultipartFile pizzaImage)
	{
		pizzaService.addPizza(pizza);
		
		String path="C:\\Users\\NIIT\\git\\SFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
		Path p=Paths.get(path+pizza.getPizzaName());
		if (!Files.exists(p))
		{    
			try
			{
				Files.createDirectory(p);
				System.out.println("Directory created");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
        }
		
		List<String> files=displayImage(pizza.getPizzaName());
		
		path=String.valueOf(p.toString()+"\\"+(files.size()+1)+".jpg");
		System.out.println(path);
		File imageFile=new File(path);
		
		if(!pizzaImage.isEmpty())
		{
			try
			{
				byte buffer[]=pizzaImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);
				bos.close();
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
	
		return "redirect:/";
	}
	
	
	@GetMapping("/display")
	public String m2(ModelMap map)
	{
		List<Pizza> products=new ArrayList<Pizza>();
		List<String> images=new ArrayList<String>();
		for(Pizza p:pizzaService.displayAllPizza())
		{
			List<String> im=displayImage(p.getPizzaName());
			if(!im.isEmpty())
			p.setImagelink(im.get(0));	
			products.add(p);
		}
		map.addAttribute("pizza",products);
		return "displaypizza";
	}
	
	public List<String> displayImage(String pizzaname)
	{

		List<String> images=new ArrayList();
		
		try
		{
			String path="C:\\Users\\NIIT\\git\\SFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
			Path p=Paths.get(path+pizzaname);
			DirectoryStream<Path> files=Files.newDirectoryStream(p,"*.*");
			
			for(Path file:files)
			{
//				FileInputStream fis=new FileInputStream(file.toString());
//				byte[] arr=new byte[fis.available()];
//				fis.read(arr);
				
				images.add(file.getFileName().toString());
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return images;
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
	
	@PostMapping("/search")
	public String m5(@RequestParam("search") String pizzaname,ModelMap map)
	{
		List<Pizza> pizzas=pizzaService.displayPizzaByName(pizzaname);
		map.addAttribute("pizza",pizzas);
		return "displaypizza";
	}
}
