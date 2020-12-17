package ie.assignment2.forms;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewMovieForm {
	@Size(min=1, max=30, message="movie title must be between 4 and 30 characters")
	private String title;
	
	@Min(value=1888, message="movie year must be between 1888 and current year")
	private int year;
	
	@NotNull
	private int directorId;

	/*@Size(min=4, max=30, message="Please make sure that the word length is between 4 and 30")
	private String title;
	
	@Min(value=1988, message="No movies before 1988")
	private int year;*/
	
}
