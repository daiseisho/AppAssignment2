package ie.assignment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.assignment2.dao.UserDao;
import ie.assignment2.entities.MyUser;
@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public MyUser save(MyUser aUser) {
		if(userDao.existsByUserEmail(aUser.getUserEmail())) {
			return null;
		}		
		return userDao.save(aUser);
	}

	@Override
	public MyUser addUser(String firstName, String lastName, boolean admin, String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
