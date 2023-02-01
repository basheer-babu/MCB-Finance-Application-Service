package com.mcb.minifinanceltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.minifinanceltd.entity.MCB_products;
import com.mcb.minifinanceltd.entity.Users;


public interface MCBusers extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);



}
