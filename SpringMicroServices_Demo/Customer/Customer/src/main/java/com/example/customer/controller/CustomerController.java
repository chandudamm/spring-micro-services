package com.example.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	private static List<Customer> customersList = new ArrayList<>();
	
	static {
		for(int i=1; i<=10; i++) {
			Customer customer = new Customer(i, "Customer"+i, "CustEmail"+i+"@gmail.com");
			customersList.add(customer);
		}
		customersList.forEach(System.out::println);
	}
	//test
	/*public static void main(String[] args) {
		CustomerController ctrl = new CustomerController();
	}*/
	
	@RequestMapping(path="/customers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers(){
		return customersList;
	}
	
	@RequestMapping(path="/customers/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomer(@PathVariable("id") long customerId){
		Optional<Customer> customer = null;
		customer = customersList.stream().filter(cust -> cust.getId() == customerId).findAny();
		return customer.get();
	}

}
