package ie.assignment2.service;

import ie.assignment2.entities.MyUser;

public interface UserService {
	MyUser save(MyUser aUser);

	MyUser addUser(String email, String password,String firstName, String lastName, String role);


}
