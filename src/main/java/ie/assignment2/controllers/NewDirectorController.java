package ie.assignment2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.assignment2.entities.Director;
import ie.assignment2.forms.NewDirectorForm;
import ie.assignment2.service.DirectorService;

@Controller
public class NewDirectorController {
	
	@Autowired
	DirectorService directorService;
	
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

}
