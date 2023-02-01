package com.mcb.minifinanceltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.minifinanceltd.entity.MCB_products;
import com.mcb.minifinanceltd.entity.Users;

@Repository
public interface MCBProductRepository extends JpaRepository<MCB_products, Integer> {


}
