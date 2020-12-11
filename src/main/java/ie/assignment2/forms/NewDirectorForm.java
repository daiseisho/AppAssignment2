package ie.assignment2.forms;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewDirectorForm {
	@Size(min = 4, max = 30)
	@Pattern(regexp="[^0-9]*",message="The first name should not have numbers")
	private String firstName;
	
	@Size(min = 4, max = 30)
	@Pattern(regexp="[^0-9]*",message="The last name should not have numbers")
	private String lastName;
	
}
