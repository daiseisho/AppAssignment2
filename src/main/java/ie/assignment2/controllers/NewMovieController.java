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
import ie.assignment2.forms.NewMovieForm;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
@Controller
public class NewMovieController {
	
	@Autowired
	MovieService movieService;
	@Autowired
	DirectorService directorService;
	
	@GetMapping("/newmovie")
	public String addMovie(Model model)
	{
		List<Director> directorList = directorService.getDirectorsAlphabetical();
		model.addAttribute("directors", directorList);
		model.addAttribute("newMovieForm", new NewMovieForm());
		return "newmovie";
	}
	
	@PostMapping("newmovie")
	public String addMoviePost(Model model, @Valid NewMovieForm newMovieForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			List<Director> directorList = directorService.getDirectorsAlphabetical();
			model.addAttribute("directors", directorList);
			return "newmovie";
		}
		
		Director director = directorService.getDirectorById(newMovieForm.getDirectorId());
			
		Movie movie = movieService.addMovie(newMovieForm.getTitle(), director, newMovieForm.getYear());
		if(movie == null) {
			redirectAttributes.addFlashAttribute("pastMaxYearRange", newMovieForm.getYear());
			return "redirect:newmovie";
		}
		
		return "redirect:movies/";
	}	

}
