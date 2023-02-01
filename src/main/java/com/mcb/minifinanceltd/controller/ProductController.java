package com.mcb.minifinanceltd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.mcb.minifinanceltd.entity.MCB_products;
import com.mcb.minifinanceltd.entity.Orders;
import com.mcb.minifinanceltd.entity.Users;
import com.mcb.minifinanceltd.service.ProductService;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService service;


    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        return service.login(user);
    }

    @PostMapping("/addProduct")
    public MCB_products addProduct(@RequestBody MCB_products product) {
        return service.saveProduct(product);
    }

    @GetMapping("/products")
    public List<MCB_products> findAllProducts() {
        return service.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PostMapping("/placeOrder")
    public Orders placeOrder(@RequestBody Orders orders) {
        return service.placeOrder(orders);
    }

}
