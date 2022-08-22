package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
//	public T save(T m);
//	public void delete(T m);
//	public void deleteById(primaryKeyType id);
//	public List<T> findAll();
//	public T findById(primaryKeyType id);
	
	public List<Movie> findByTitle(String title);
	
	@Query(value = "select m from Movie m where m.rating>?1", nativeQuery = false)
	public List<Movie> findBetterRatedMovies(double rating);
}


//public interface MovieRepository {
//	public Movie saveMovie(Movie m);
//	public void deleteMovie(Movie m);
//	public void deleteMovieById(primaryKeyType id);
//	public List<Movie> findAllMovies();
//	public Movie findMovieById(primaryKeyType id);
//}
//
//
//interface BookRepository {
//	public Book saveBook(Book m);
//	public void deleteBook(Book m);
//	public void deleteBookById(primaryKeyType id);
//	public List<Book> findAllBooks();
//	public Book findBookById(primaryKeyType id);
//}
//
//interface UserRepository {
//	public User saveUser(User m);
//	public void deleteUser(User m);
//	public void deleteUserById(primaryKeyType id);
//	public List<User> findAllUsers();
//	public User findUserById(primaryKeyType id);
//}
