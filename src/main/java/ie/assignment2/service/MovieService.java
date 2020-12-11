package ie.assignment2.service;

import java.util.List;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;

public interface MovieService{
	List<Movie> getAllMoviesOrderByChronologicalOrder();
	Movie addMovie(String title, Director movieDirector, int year);
	boolean updateMovieTitle(String title, int id);
	boolean deleteMovie(int id);
	List<Movie> getAllMoviesByDirector(int directorID);
	List<Movie> getAllMoviesByYear(int year);

}
