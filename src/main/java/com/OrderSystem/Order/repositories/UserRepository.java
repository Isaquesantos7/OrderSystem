package com.OrderSystem.Order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderSystem.Order.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
