package ie.assignment2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.assignment2.entities.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer>{
	List<Movie> findAllByOrderByYear();
	List<Movie> findAllByMovieDirector_DirectorID(int directorID);
	
	@Modifying
	@Transactional
	@Query("UPDATE Movie m SET m.title = :newTitle WHERE m.movieID = :movieID")
	void changeMovieTitle(@Param("newTitle") String title, @Param("movieID") int movieID);
	boolean existsByMovieID(int id);

}
