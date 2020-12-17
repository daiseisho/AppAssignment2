package ie.assignment2.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewUserForm {
	@Size(min=4, max=30)
	@Pattern(regexp="[^0-9]*",message="user first name should not have numbers")
	private String firstName;
	
	@Size(min=4, max=30)
	@Pattern(regexp="[^0-9]*",message="user last name should not have numbers")
	private String lastName;
	
	@NotNull
	private String role;
	
	@Size(min=4, message="email should be at least 4 characters")
	private String userEmail;
	
	@Size(min=6, max=30, message="Password should be between 6 and 30 characters")
	private String userPassword;
	
}
