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
import ie.assignment2.entities.User;
import ie.assignment2.forms.NewDirectorForm;
import ie.assignment2.forms.NewMovieForm;
import ie.assignment2.forms.NewUserForm;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
import ie.assignment2.service.UserService;

@Controller
public class AuthenticatedUserControllers {

	
	@Autowired
	UserService userService;
	@Autowired
	DirectorService directorService;
	@Autowired
	MovieService movieService;
	
	@GetMapping("/newdirector")
	public String addDirector(Model model)
	{
		model.addAttribute("newDirectorForm", new NewDirectorForm());
		return "newdirector";
	}
	
	@PostMapping("newdirector")
	public String addDirectorPost(@Valid NewDirectorForm newDirectorForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors())
			return "newdirector";
			
		Director director = directorService.addDirector(newDirectorForm.getFirstName(), newDirectorForm.getLastName());
		if(director == null) {
			redirectAttributes.addFlashAttribute("duplicateDirectorName", newDirectorForm.getFirstName() + ' ' + newDirectorForm.getLastName());
			return "redirect:newdirector";
		}
		
		return "redirect:directors/";
	}
	
	
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
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/newuser")
	public String addUser(Model model)
	{
		model.addAttribute("newUserForm", new NewUserForm());
		return "newuser";
	}
	
	@PostMapping("newuser")
	public String addUserPost(@Valid NewUserForm newUserForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			return "newuser";
		}
			
		User user = userService.addUser(
				newUserForm.getFirstName(),
				newUserForm.getLastName(),
				newUserForm.isAdmin(),
				newUserForm.getEmail(),
				newUserForm.getPassword());
		
		System.out.println(user.toString());
		/*if(user == null) {
			redirectAttributes.addFlashAttribute("pastMaxYearRange", newMovieForm.getYear());
			return "redirect:newmovie";
		}*/
		
		return "redirect:/";
	}	
	
	
	
	
	
	
	
	
	
	
}