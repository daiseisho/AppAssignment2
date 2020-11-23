package ie.assignment2.service;

import java.util.List;

import ie.assignment2.entities.Director;

public interface DirectorService {
	List<Director> getDirectorsAlphabetical();
	boolean addDirector(String firstName, String lastName);
	boolean deleteDirector(int id);
	Director getDirectorById(int id);
	
	

}
