package ie.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	
}