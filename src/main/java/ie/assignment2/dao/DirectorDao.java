package ie.assignment2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.assignment2.entities.Director;

public interface DirectorDao extends JpaRepository<Director, Integer>{
	List<Director> findAllByOrderByLastNameDesc();
	boolean existsByDirectorID(int id);
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
	Director findByDirectorID(int id);
}
