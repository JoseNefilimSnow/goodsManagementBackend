package com.guri.goodsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guri.goodsManagement.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
