package ie.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.assignment2.entities.MyUser;

public interface UserDao extends JpaRepository<MyUser, String> {
	boolean existsByUserEmail(String userEmail);
	

}
