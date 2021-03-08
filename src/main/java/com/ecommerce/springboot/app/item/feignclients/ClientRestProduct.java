package com.ecommerce.springboot.app.item.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.springboot.app.item.models.Product;

@FeignClient(name="products-service")
public interface ClientRestProduct {
	
	@GetMapping("/products")
	public List<Product> getProducts();
	
	@GetMapping("/productDetail/{id}")
	public Product getProducts(@PathVariable Long id);

}
