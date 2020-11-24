package ie.assignment2.forms;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewDirectorform {
	@Size(min=4, max=30, message="Please make sure that the first name of the director is between 4 and 30 characters")
	private String firstName;
	
	@Size(min=4, max=30, message="Please make sure that the surname of the director is between 4 and 30 characters")
	private String lastName;

}
