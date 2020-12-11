package ie.assignment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.assignment2.dao.UserDao;
import ie.assignment2.entities.User;
@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User addUser(String firstName, String lastName, boolean isAdmin, String email, String password) {
		// TODO Auto-generated method stub
		try {
			User user = new User(
					firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase(), 
					lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase(), 
					isAdmin,
					email,
					password);
			
			userDao.save(user);
			return user;
		}catch(Exception e) {
			return null;
		}
	}

}
