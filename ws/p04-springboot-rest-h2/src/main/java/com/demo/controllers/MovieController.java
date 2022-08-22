package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.services.MovieService;

@RestController
//@CrossOrigin
@CrossOrigin(origins = {"https://hoppscotch.io/"})
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping("")
	public List<Movie> getAllMovies(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable int id){
		return service.findOneById(id);
	}
	
	@PostMapping("")
	public Movie saveMovie(@RequestBody Movie movie){
		return service.createNewMovie(movie);
	}
	
	// update 
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie){
		return service.updateMovie(id, movie);
	}
	
	// delete
	@DeleteMapping("/{id}")
	public Movie deleteMovie(@PathVariable int id) {
		return service.deleteMovie(id);
	}
	// findByTitle
}
