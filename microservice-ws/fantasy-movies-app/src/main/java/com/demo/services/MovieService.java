package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Movie;
import com.demo.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;
	
	public Movie createMovie(Movie m) {
		return repo.save(m);
	}
	
	public List<Movie> getAllMovies(){
		return repo.findAll();
	}
	
	public Movie getMovieById(int id){
		Optional<Movie> optional = repo.findById(id);
		if(optional.isEmpty()) {
			// no data found
			return null;
		} else {
			return optional.get();
		}
	}
	
	public List<Movie> filterMoviesByRating(double r){
		return repo.findBetterRatedMovies(r);
	}

	public Movie deleteMovieById(int id){
		Movie movie = getMovieById(id);
		if(movie!=null){
			repo.deleteById(id);
		}
		return movie;
	}

	
	
}
