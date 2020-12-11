package ie.assignment2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;

@RestController
@RequestMapping("myapi")
public class MyRestController {
	
	@Autowired
	DirectorService directorService;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movie/year/{year}")
	ResponseEntity<List<Movie>> getMoviesByReleaseYear(@PathVariable("year") int year) {
		List<Movie> movieList = movieService.getAllMoviesByYear(year);
		if(movieList.isEmpty())
				return new ResponseEntity<List<Movie>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Movie>>(movieList, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/director/delete/{id}")
	ResponseEntity<Director> deleteDirectorById(@PathVariable("id") int id) {
		Boolean status = directorService.deleteDirector(id);
		if(status)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
