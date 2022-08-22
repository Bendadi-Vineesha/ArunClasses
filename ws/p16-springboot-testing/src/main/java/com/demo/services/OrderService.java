package com.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Order;
import com.demo.exceptions.OrderException;
import com.demo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public Order placeOrder(Order order) throws OrderException {
		try {
			return repo.save(order);
		} catch(Exception e) {
			throw new OrderException(e.getMessage());
		}
	}
	
	public Order findOrder(int id) throws OrderException {
		Optional<Order> optional = repo.findById(id);
		if(optional.isEmpty()) {
			throw new OrderException("Id not found");
		} else {
			return optional.get();
		}
	}

}
