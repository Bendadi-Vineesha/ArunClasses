package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.exceptions.MovieException;
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
	public Movie getMovie(@PathVariable int id) throws MovieException{
		return service.findOneById(id);
	}
	
	@PostMapping(
		value="", 
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
		consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public Movie saveMovie(@RequestBody Movie movie){
		return service.createNewMovie(movie);
	}
	
	// update 
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) throws MovieException{
		return service.updateMovie(id, movie);
	}
	
	// delete
	@DeleteMapping("/{id}")
	public Movie deleteMovie(@PathVariable int id) throws MovieException {
		return service.deleteMovie(id);
	}
	// findByTitle
	@GetMapping("/by") // localhost:8080/api/v1/movies/by?title=superman
	public List<Movie> findBy(@RequestParam String title, @RequestParam double ratings){
		return service.findByTitleAndRating(title, ratings);
	}
	
}
