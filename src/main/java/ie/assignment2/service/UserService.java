package ie.assignment2.service;

import ie.assignment2.entities.User;

public interface UserService {
	User addUser(String firstName, String lastName, boolean isAdmin, String email, String password);

}
