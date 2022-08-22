package com.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.clients.FantasyMoviesClient;
import com.demo.models.Show;

@RestController
@RequestMapping("/shows/api/v1")
public class ShowController {

	@Autowired
	private FantasyMoviesClient client;
	
	@GetMapping("")
	public List<Show> getAllShows(){
		return Arrays.asList(
//			new Show("Superman is flying again", "Miley", 4.7),
			new Show("Batman is a day", "John", 4.6),
			new Show("Antman is not ant", "Tom", 4.1),
			new Show("Hulk is red now", "Me", 4.8)
		);
	}
	
	@GetMapping("/fantasy-movies")
	public List<Show> getAllFantasyMovies(){
		return client.getMovies();
	}
	
}
