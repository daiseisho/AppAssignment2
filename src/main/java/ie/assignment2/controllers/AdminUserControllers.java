package ie.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;

@Controller
public class AdminUserControllers {
	
	@Autowired
	DirectorService directorService;
	@Autowired
	MovieService movieService;
	
	@GetMapping("/directors/delete/{directorID}")
	public String deleteDirector(@PathVariable("directorID") String directorID, Model model) {
		if(directorService.deleteDirector(Integer.parseInt(directorID))) {
			return "redirect:/directors";
		}
		model.addAttribute("error", "unable to delete, Director not found");
		return "notfounderror";
	}
	
	@GetMapping("/movies/delete/{movieID}")
	public String deleteMovie(@PathVariable("movieID") String movieID, Model model) {
		if(movieService.deleteMovie(Integer.parseInt(movieID))) {
			return "redirect:/movies";
		}
		model.addAttribute("error", "unable to delete, Movie not found");
		return "notfounderror";
	}
	

}
