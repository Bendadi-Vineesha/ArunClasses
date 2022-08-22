package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Movie;
import com.demo.services.MovieService;

@SpringBootApplication
public class MyApplication implements CommandLineRunner{
	
	@Autowired
	private MovieService service;
	
	@Override
	public void run(String... args) throws Exception {
		Movie m = null;
		m = service.createMovie(new Movie("Superman", "Mark", 4.9));
		System.out.println(m);
		m = service.createMovie(new Movie("Batman", "Emily", 3.9));
		System.out.println(m);
		m = service.createMovie(new Movie("Spiderman", "Tom", 4.2));
		System.out.println(m);
		m = service.createMovie(new Movie("Ironman", "Ross", 4.3));
		System.out.println(m);
		m = service.createMovie(new Movie("Shaktiman", "Mark", 4.7));
		System.out.println(m);
		
		
		
		List<Movie> movies = service.getAllMovies();
		System.out.println(movies);
		

		List<Movie> topRatedMovies = service.filterMoviesByRating(4.5);
		System.out.println(topRatedMovies);

		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

}
