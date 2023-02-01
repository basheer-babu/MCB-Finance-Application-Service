package com.mcb.minifinanceltd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mcb.minifinanceltd.entity.MCB_products;
import com.mcb.minifinanceltd.entity.Orders;
import com.mcb.minifinanceltd.entity.Users;
import com.mcb.minifinanceltd.repository.MCBOrders;
import com.mcb.minifinanceltd.repository.MCBProductRepository;
import com.mcb.minifinanceltd.repository.MCBusers;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
	@Autowired
	private MCBProductRepository repository;
	
	@Autowired
	private MCBusers usersRepo;
	
	@Autowired
	private MCBOrders orderRepo;
	

	public MCB_products saveProduct(MCB_products product) {
		System.out.println("product" + product);
		return repository.save(product);
	}

	public List<MCB_products> getProducts() {
		return repository.findAll();
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public Users login(Users user) {
		
		return usersRepo.findByUsername(user.getUsername());
	}

	public Orders placeOrder(Orders orders) {
		// TODO Auto-generated method stub
		return orderRepo.save(orders);
	}

}
