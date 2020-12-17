package ie.assignment2.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;
import ie.assignment2.forms.EditMovieForm;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
@Controller
public class EditMovieController {
	
	@Autowired
	MovieService movieService;
	@Autowired
	DirectorService directorService;
	
	@GetMapping("/editmovie")
	public String editMovie(Model model)
	{
		List<Movie> movieList = movieService.getAllMoviesOrderByChronologicalOrder();
		model.addAttribute("movies", movieList);
		model.addAttribute("editMovieForm", new EditMovieForm());
		return "editmovie";
	}
	
	@PostMapping("editmovie")
	public String editMoviePost(Model model, @Valid EditMovieForm editMovieForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			List<Director> directorList = directorService.getDirectorsAlphabetical();
			model.addAttribute("directors", directorList);
			return "editmovie";
		}
		
		movieService.updateMovieTitle(editMovieForm.getTitle(), editMovieForm.getMovieId());
		
		return "redirect:movies/";
	}	

}
