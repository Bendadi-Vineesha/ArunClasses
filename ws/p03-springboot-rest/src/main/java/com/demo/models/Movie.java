package com.demo.models;

public class Movie {

	private int id;
	private String title;
	private String director;
	private double ratings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", ratings=" + ratings + "]";
	}
	public Movie() {
	}
	public Movie(int id, String title, String director, double ratings) {
		this(title, director, ratings);
		this.id = id;
	}
	public Movie(String title, String director, double ratings) {
		super();
		this.title = title;
		this.director = director;
		this.ratings = ratings;
	}	
}
