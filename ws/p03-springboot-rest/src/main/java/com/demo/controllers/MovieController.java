package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Movie;
import com.demo.services.MovieService;

@RestController
//@CrossOrigin
@CrossOrigin(origins = {"https://hoppscotch.io/"})
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping("/api/v1/movies")
	public List<Movie> getAllMovies(){
		return service.findAll();
	}
}
