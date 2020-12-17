package ie.assignment2.forms;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EditMovieForm {
	@Size(min=1, max=30, message="movie title must be between 4 and 30 characters")
	private String title;
	
	private int movieId;

	
}