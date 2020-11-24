package ie.assignment2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import ie.assignment2.dao.DirectorDao;
import ie.assignment2.entities.Director;
@Service
@Slf4j
public class DirectorServiceImplementation implements DirectorService {
	@Autowired
	DirectorDao directorDao;
	
	@Override
	public List<Director> getDirectorsAlphabetical() {
		return directorDao.findAllByOrderByLastNameDesc();
	}

	@Override
	public Director addDirector(String firstName, String lastName) {
		
		Director d=null;
		
		
		try {
			d=new Director(firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase(),
					lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase());
			
			directorDao.save(d);
		return d;
		} catch(Exception e) {
			return d;
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
