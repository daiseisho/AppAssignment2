package ie.assignment2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
import ie.assignment2.service.UserService;

@Controller
public class AnyUserControllers {
	
	@Autowired
	UserService userService;
	@Autowired
	DirectorService directorService;
	@Autowired
	MovieService movieService;
	
	@GetMapping("/directors")
	public String getAllDirectorsAlphabetically(Model model) {
		List<Director> directorList = directorService.getDirectorsAlphabetical();
		
		if(directorList.isEmpty()) {
			model.addAttribute("noDirectors", "No directors in the databse");
			return "directors";
		}
		model.addAttribute("directors", directorList);
		return "directors";
		}
	
	@GetMapping("/movies/{directorID}")
	public String getAllMoviesByDirectorID(@PathVariable("directorID") String directorID, Model model) {
		try {
			List<Movie> movieList = movieService.getAllMoviesByDirector(Integer.parseInt(directorID));
			if(movieList.isEmpty()) {
				model.addAttribute("noMovies", "no movies created by this director");
				return "movies";
			}
			model.addAttribute("movies", movieList);
			return "movies";
			
		}catch(Exception e) {
			model.addAttribute("error", "error ocurred when getting all movies by a director");
			return "notfounderror";
		}
	}
	
	@GetMapping("/movies")
	public String getAllMoviesInChronologicalOrder(Model model) {
		try {
			List<Movie> movieList = movieService.getAllMoviesOrderByChronologicalOrder();
			if(movieList.isEmpty()) {
				model.addAttribute("noMovies", "no movies in the database");
				return "movies";
			}
			model.addAttribute("movies", movieList);
			return "movies";
			
		}catch(Exception e) {
			model.addAttribute("error", "error ocurred when getting all movies");
			return "notfounderror";
		}
	}
	
	@GetMapping("/")
	public String loadHomePage() {
		return "home";
	}
	
}


