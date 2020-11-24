package ie.assignment2.forms;

import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class NewMovieForm {

	@Size(min=4, max=30, message="Please make sure that the word length is between 4 and 30")
	private String title;
	
	@Min(value=1988, message="No movies before 1988")
	private int year;
	
}
