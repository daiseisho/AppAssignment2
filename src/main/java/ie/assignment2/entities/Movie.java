package ie.assignment2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieID;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private int year;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false)
	private Director movieDirector;
	
	public Movie(String title, Director movieDirector, int year) {
		this.title = title;
		this.movieDirector = movieDirector;
		this.year = year;
	}

}
