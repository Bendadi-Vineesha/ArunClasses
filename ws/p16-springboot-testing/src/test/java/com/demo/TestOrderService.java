package com.demo;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.demo.entities.Order;
import com.demo.exceptions.OrderException;
import com.demo.repositories.OrderRepository;
import com.demo.services.OrderService;

@SpringBootTest
@ActiveProfiles("test")
public class TestOrderService {

	@Autowired
	private OrderService service;
	
	@MockBean
	private OrderRepository repo;
	
	@Test
	public void testPlaceOrder() throws OrderException {
		Order order = new Order("mobile", 2);
		
		Mockito.when(repo.save(order)).thenReturn(new Order(125, "mobile", 2));
		
		Order placedOrder = service.placeOrder(order);
		System.out.println(placedOrder);
		
		Assertions.assertTrue(placedOrder.getId()>0);
		Assertions.assertEquals(placedOrder.getItem(), order.getItem());
	}
	
	@Test
	public void testShouldNotPlaceOrder() throws OrderException {
		Order order = new Order("", 2);
		
		Mockito.when(repo.save(order)).thenThrow(RuntimeException.class);
		
		Assertions.assertThrows(OrderException.class, ()->{			
			service.placeOrder(order);
		});
	}
	
	@Test
	public void shouldFindOrderById() throws OrderException {
		int idToFind = 1486;
		Mockito
			.when(
				repo.findById(idToFind)
			)
			.thenReturn(
				Optional.of(
					new Order(idToFind, "bike", 1)
				)
			);
		
		Order order = service.findOrder(idToFind);
		Assertions.assertTrue(order.getId()==idToFind);
		
	}
	
	@Test
	public void shouldNotFindOrderById() throws OrderException {
		int idToFind = 5;
		Mockito
			.when(
				repo.findById(idToFind)
			)
			.thenReturn(
				Optional.ofNullable(null)
			);
		
		Assertions.assertThrows(OrderException.class, ()->{			
			service.findOrder(idToFind);
		});

	}
	
}
