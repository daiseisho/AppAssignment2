package ie.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.User;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
import ie.assignment2.service.UserService;
@SpringBootApplication
public class Assignemnt2Application implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	@Autowired
	MovieService movieService;
	@Autowired
	DirectorService directorService;

	public static void main(String[] args) {
		SpringApplication.run(Assignemnt2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception { 
		directorService.addDirector("adam", "Holland");
		directorService.addDirector("tash", "hayes");
		movieService.addMovie("the big bang", directorService.getDirectorById(1), 2015);
		movieService.addMovie("wowzers the movie 2", directorService.getDirectorById(1), 2020);
		movieService.addMovie("wowzers the movie", directorService.getDirectorById(1), 2010);

		User added = userService.addUser("adam", "holland", true, "test@gmail.com", "testinggg");
	}

}
