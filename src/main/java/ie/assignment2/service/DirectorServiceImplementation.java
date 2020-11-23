package ie.assignment2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.assignment2.dao.DirectorDao;
import ie.assignment2.entities.Director;
@Service
public class DirectorServiceImplementation implements DirectorService {
	@Autowired
	DirectorDao directorDao;
	
	@Override
	public List<Director> getDirectorsAlphabetical() {
		return directorDao.findAllByOrderByLastNameDesc();
	}

	@Override
	public boolean addDirector(String firstName, String lastName) {
		// TODO Auto-generated method stub
		try {
		directorDao.save(new Director(
				firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase(),
				lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase()));
		return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteDirector(int id) {
		if(directorDao.existsByDirectorID(id)) {
			directorDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Director getDirectorById(int id) {
		// TODO Auto-generated method stub
		return directorDao.findByDirectorID(id);
	}

}
