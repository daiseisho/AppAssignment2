package ie.assignment2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ie.assignment2.dao.UserDao;
import ie.assignment2.entities.MyUser;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	 public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<MyUser> optionalUser = userDao.findById(userName);
        if(optionalUser.isPresent()) 
        {
         MyUser myUser = optionalUser.get();
                          
            return User.builder()
             .username(myUser.getUserEmail())
             .password( myUser.getUserPassword() )
             .disabled( false )
             .accountExpired( false )
             .accountLocked( false )
             .roles( myUser.getRole() )
             .build();
        } else {
         throw new UsernameNotFoundException("User Name " + userName + " is not Found");
        }   
    }
}