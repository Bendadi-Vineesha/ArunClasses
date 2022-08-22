package com.demo.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.models.Movie;

@Repository
public class MovieRepository {

	private List<Movie> movies = Arrays.asList(
			new Movie(34, "Superman", "John", 4.6),
			new Movie(14, "Spiderman", "Miley", 3.6),
			new Movie(25, "Hanuman", "Shiva", 5.0),
			new Movie(348, "Gentleman", "Mark", 4.9)
	);
	
	public List<Movie> getAllMovies() {
		return new ArrayList<Movie>(this.movies);
	}
	
}
