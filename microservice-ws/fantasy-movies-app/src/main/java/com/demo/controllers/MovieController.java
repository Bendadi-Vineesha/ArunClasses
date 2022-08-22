package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.services.MovieService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://hoppscotch.io/"})
@RequestMapping("/superheros")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable int id){
		return movieService.getMovieById(id);
	}
	@PostMapping("/movies")
	public Movie saveNewMovie(@RequestBody Movie m){
		System.out.println(m);
		return movieService.createMovie(m);
	}
	@DeleteMapping("/movies/{id}")
	public Movie deleteById(@PathVariable int id){
		return movieService.deleteMovieById(id);
	}
	
}
