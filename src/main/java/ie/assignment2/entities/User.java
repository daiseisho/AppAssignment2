package ie.assignment2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private boolean admin;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	public User(String firstName, String lastName, boolean isAdmin, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = isAdmin;
		this.email = email;
		this.password = password;
	}

}
