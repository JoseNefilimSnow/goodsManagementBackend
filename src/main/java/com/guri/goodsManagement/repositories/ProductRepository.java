package com.guri.goodsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guri.goodsManagement.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
