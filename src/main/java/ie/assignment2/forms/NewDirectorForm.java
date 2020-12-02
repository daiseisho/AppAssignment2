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
	@Pattern(regexp="[^0-9]*",message="The first name should not have numbers")
	private String lastName;
	
	/*@Pattern(regexp="[^0-9]*",message="The first name should not have numbers")
	@Size(min=4, max=30, message="Please make sure that the first name of the director is between 4 and 30 characters")
	private String firstName;
	
	@Pattern(regexp="[^0-9]*",message="The last name should not have numbers")
	@Size(min=4, max=30, message="Please make sure that the surname of the director is between 4 and 30 characters")
	private String lastName;*/

}
