package com.guri.goodsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guri.goodsManagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
