package com.mcb.minifinanceltd.service;

import com.mcb.minifinanceltd.entity.MCB_products;
import com.mcb.minifinanceltd.entity.Orders;
import com.mcb.minifinanceltd.entity.Users;
import com.mcb.minifinanceltd.repository.MCBOrders;
import com.mcb.minifinanceltd.repository.MCBProductRepository;
import com.mcb.minifinanceltd.repository.MCBusers;
import com.mcb.minifinanceltd.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @Mock
    MCBProductRepository repository;

    @Mock
    MCBusers usersRepo;

    @Mock
    MCBOrders orderRepo;
    @InjectMocks
    ProductService productService;

    MCB_products products = null;

    @BeforeEach
    public void init() {
        products = new MCB_products(1, "100", "basheer", "description", "image", "charge", "t&c");
    }

    @Test
    void saveProduct() {
        Mockito.when(repository.save(products)).thenReturn(products);
        assertNotNull(productService.saveProduct(products));
    }

    @Test
    void getProducts() {
        List<MCB_products> mcb_productsList = new ArrayList<>();
        mcb_productsList.add(products);
        Mockito.when(repository.findAll()).thenReturn(mcb_productsList);
        assertNotNull(productService.getProducts());
    }

    @Test
    void deleteProduct() {
        int id = 100;
        Mockito.doNothing().when(repository).deleteById(id);
        assertNotNull(productService.deleteProduct(id));
    }

    @Test
    void login() {
        Users user = new Users();
        user.setId(1);
        user.setRole("tl");
        user.setPassword("password");
        user.setUsername("admin");
        Mockito.when(usersRepo.findByUsername(user.getUsername())).thenReturn(user);
        assertNotNull(productService.login(user));
    }

    @Test
    void placeOrder() {

        Orders orders = new Orders();
        orders.setId(1);
        orders.setCurrency("MUR");
        orders.setPrice("1000");
        Mockito.when(orderRepo.save(orders)).thenReturn(orders);
        assertNotNull(productService.placeOrder(orders));
    }
}