package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Calculator{
	int add(int a, int b) {return a+b;}
}

@SpringBootTest
public class TestDemo {

	@Test
	public void firstTest() {
		Assertions.assertTrue(true);
	}

	@Test
	public void testCalculatorAdd() {
		Calculator calc = new Calculator();
		Assertions.assertTrue(calc.add(5, 4) == 9);
		Assertions.assertEquals(9, calc.add(5, 4));
	}


	
}
