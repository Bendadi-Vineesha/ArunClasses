package com.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Movie;
import com.demo.services.MovieService;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

	@Autowired
	private MovieService service;
	
	@Override
	public void run(String... args) throws Exception {
		List<Movie> movies = Arrays.asList(
				new Movie("Superman", "John", 4.6),
				new Movie("Spiderman", "Miley", 3.6),
				new Movie("Hanuman", "Shiva", 5.0),
				new Movie("Gentleman", "Mark", 4.9)
		);
		
		for(Movie m: movies) {			
			System.out.println(service.createNewMovie(m));
		}
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
}
