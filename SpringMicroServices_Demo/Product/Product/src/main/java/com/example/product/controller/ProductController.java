package com.example.product.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.domain.Product;

@RestController
@RequestMapping("/")
public class ProductController {
	
	private static List<Product> productsList = new ArrayList<>();
	
	static {
		for(int i=1; i<=10; i++) {
			Product product = new Product(i, "Units"+i, "Product"+i+"Description");
			productsList.add(product);
		}
		productsList.forEach(System.out::println);
	}
	
	@RequestMapping(path="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts(){
		return productsList;
	}
	
	@RequestMapping(path="/products/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product findProduct(@PathVariable("id") long productId){
		Optional<Product> product = null;
		product = productsList.stream().filter(prod -> prod.getId() == productId).findAny();
		return product.get();
	}

}
