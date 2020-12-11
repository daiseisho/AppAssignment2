package ie.assignment2.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.assignment2.dao.DirectorDao;
import ie.assignment2.dao.MovieDao;
import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;
@Service
public class MovieServiceImplementation implements MovieService {
	
	@Autowired
	MovieDao movieDao;
	@Autowired
	DirectorDao directorDao;

	@Override
	public List<Movie> getAllMoviesOrderByChronologicalOrder() {
		// TODO Auto-generated method stub
		return movieDao.findAllByOrderByYear();
	}

	@Override
	public boolean addMovie(String title, Director movieDirector, int year) {
		// TODO Auto-generated method stub
		if(year >= 1888 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
			try {
				movieDao.save(new Movie(title, movieDirector, year));
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateMovieTitle(String title, int id) {
		// TODO Auto-generated method stub
		if(movieDao.existsByMovieID(id)) {
			try {
				movieDao.changeMovieTitle(title, id);
				return true;
			}catch(Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteMovie(int id) {
		// TODO Auto-generated method stub
		if(movieDao.existsByMovieID(id)) {
			try {
				movieDao.deleteById(id);
				return true;
			}catch(Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Movie> getAllMoviesByDirector(int directorID) {
		// TODO Auto-generated method stub
		if(directorDao.existsByDirectorID(directorID)) {
			return movieDao.findAllByMovieDirector_DirectorID(directorID);
		}
		return null;
	}

	@Override
	public List<Movie> getAllMoviesByYear(int year) {
		// TODO Auto-generated method stub
		return movieDao.findAllByYear(year);
	}

}
