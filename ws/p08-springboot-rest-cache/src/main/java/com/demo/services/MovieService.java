package com.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	
	@Cacheable(key="#id", value="movies")
	public Movie findOneById(int id) throws MovieException {
		System.out.println("Finding movie by id: "+id+", at: "+LocalDateTime.now());
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
	
	@CachePut(key="#id", value="movies")
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
	
	@CacheEvict(key="#id", value="movies")
	public Movie deleteMovie(int id) throws MovieException {
		Movie dbMovie = findOneById(id);

//		repo.deleteById(id);
		repo.delete(dbMovie);
		

		return dbMovie;
		
	}

	@Cacheable(key="#title", value="movies")
	public List<Movie> findByTitle(String title) {
		System.out.println("Finding movie by title: "+title+", at: "+LocalDateTime.now());

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
			return findByTitle(title);
		}
		
	}
}
