package ie.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.MyUser;
import ie.assignment2.service.DirectorService;
import ie.assignment2.service.MovieService;
import ie.assignment2.service.UserService;
import ie.assignment2.security.WebSecurityConfig;
@SpringBootApplication
public class Assignemnt2Application implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	DirectorService directorService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

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


		
		MyUser adminUserOne= new MyUser ("colin.brohan@mycit.ie", passwordEncoder.encode("admin12345"),"Colin","Brohan","ADMIN");
		MyUser adminUserTwo= new MyUser ("adam.holland@mycit.ie", passwordEncoder.encode("admin23456"),"Adam","Holland","ADMIN");
		MyUser userOne=new MyUser ("Natasha.hayes@mycit.ie", passwordEncoder.encode("password"),"Natasha", "Hayes","USER");
		MyUser userTwo=new MyUser ("Alice.cooper@mycit.ie", passwordEncoder.encode("password1"),"Alice", "Cooper","USER");
		
		userService.save(adminUserOne);
		userService.save(adminUserTwo);
		userService.save(userOne);
		userService.save(userTwo);
		
		
	}

}
