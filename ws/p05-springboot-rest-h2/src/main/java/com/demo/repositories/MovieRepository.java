package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	public List<Movie> findByTitle(String title);

	@Query("select movie from Movie movie where movie.title = ?1 and movie.ratings = ?2")
	public List<Movie> findByTitleAndRating(String title, double rating);
	
}


//interface MyJpaRepository<T, PK> {
//
//	public List<T> findAll();
//	public T findById(PK id);
//	public T save(T t);
//	public void delete(T t);
//	
//}
