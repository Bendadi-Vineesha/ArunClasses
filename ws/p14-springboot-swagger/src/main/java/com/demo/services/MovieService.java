package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Movie;
import com.demo.exceptions.MovieException;
import com.demo.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;

	public List<Movie> findAll() {
		return repo.findAll();
	}
	
	public Movie findOneById(int id) throws MovieException {
		Optional<Movie> optional = repo.findById(id);
		if(optional.isEmpty()) {
//			throw new RuntimeException("Could not find movie with id: "+id);
			throw new MovieException("Could not find movie with id: "+id);

		} else {
			return optional.get();
		}
	}
	
	public Movie createNewMovie(Movie m) {
		return repo.save(m);
	}
	
	public Movie updateMovie(int id, Movie m) throws MovieException {
		Movie dbMovie = findOneById(id);
		if(m.getTitle()!=null) {
			dbMovie.setTitle(m.getTitle());
		}
		if(m.getDirector()!=null) {
			dbMovie.setDirector(m.getDirector());
		}
		if(m.getRatings()>0) {
			dbMovie.setRatings(m.getRatings());
		}
		
		return repo.save(dbMovie);
	}
	
	public Movie deleteMovie(int id) throws MovieException {
		Movie dbMovie = findOneById(id);

//		repo.deleteById(id);
		repo.delete(dbMovie);

		return dbMovie;
		
	}

	public List<Movie> findByTitle(String title) {
		if(title!=null) {			
			return repo.findByTitle(title);
		} else {
			return new ArrayList<Movie>();
		}
	}
	
	public List<Movie> findByTitleAndRating(String title, double rating) {
	
		if(rating>0) {
			return repo.findByTitleAndRating(title, rating);			
		} else {
			return repo.findByTitle(title);
		}
		
	}
	
	

}
