package com.mcb.minifinanceltd;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcb.minifinanceltd.controller.JwtAuthenticationController;
import com.mcb.minifinanceltd.entity.Users;
import com.mcb.minifinanceltd.repository.MCBusers;

@SpringBootApplication
public class MinifinanceltdApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(MinifinanceltdApplication.class, args);
		System.out.println("Finance App Is Running...");
		

		
		
	}

}
