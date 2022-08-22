package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
