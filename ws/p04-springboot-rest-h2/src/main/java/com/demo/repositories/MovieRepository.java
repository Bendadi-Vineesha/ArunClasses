package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}


//interface MyJpaRepository<T, PK> {
//
//	public List<T> findAll();
//	public T findById(PK id);
//	public T save(T t);
//	public void delete(T t);
//	
//}
