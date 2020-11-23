package ie.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.assignment2.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
