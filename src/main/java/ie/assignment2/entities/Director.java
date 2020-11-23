package ie.assignment2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int directorID;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@OneToMany(mappedBy = "movieDirector", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Movie> directorMovies = new ArrayList<>();
	
	public Director(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
