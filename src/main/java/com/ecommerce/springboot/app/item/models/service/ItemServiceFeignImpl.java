package com.ecommerce.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.springboot.app.item.feignclients.ClientRestProduct;
import com.ecommerce.springboot.app.item.models.Item;

@Service("serviceFeign")
//@Primary
public class ItemServiceFeignImpl implements ItemService {
	
	@Autowired
	private ClientRestProduct clienRestProduct;

	@Override
	public List<Item> findAll() {
		return clienRestProduct.getProducts().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item finById(Long id, Integer quantity) {
		return new Item(clienRestProduct.getProducts(id), quantity);
	}

}
