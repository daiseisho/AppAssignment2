package ie.assignment2.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.assignment2.entities.Director;
import ie.assignment2.forms.NewDirectorForm;
import ie.assignment2.service.DirectorService;

@Controller
public class AuthenticatedUserControllers {
	
	@GetMapping("/newdirector")
	public String addADirector(@Valid NewDirectorForm newDirectorForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors())
			return"newdirector";
/*		Director director=DirectorService.addDirector(newDirectorForm.getFirstName(),newDirectorForm.getLastName());
		if(director==null) {
			
			redirectAttributes.addFlashAttribute("duplicateDirectorname", newDirectorForm.getFirstName());
			redirectAttributes.addFlashAttribute("duplicateDirectorname", newDirectorForm.getLastName());
			return
		}
*/
		return "";
		
	}

}
