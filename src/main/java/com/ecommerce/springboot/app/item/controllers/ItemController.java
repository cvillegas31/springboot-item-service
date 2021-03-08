package com.ecommerce.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springboot.app.item.models.Item;
import com.ecommerce.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	//@Qualifier("serviceFeign") //It is an alternative to @Primary
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@GetMapping("/listItem")
	public List<Item> listItem(){
		return itemService.findAll();
	}
	
	@GetMapping("/item/{id}/quantity/{quantity}")
	public Item itemDetail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.finById(id, quantity);		
	}

}
