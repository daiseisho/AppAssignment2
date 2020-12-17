package ie.assignment2;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import ie.assignment2.entities.Director;
import ie.assignment2.entities.Movie;
import ie.assignment2.entities.MyUser;

@Configuration
public class RestRepoConfig implements RepositoryRestConfigurer {
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Director.class);
		config.exposeIdsFor(Movie.class);
		config.exposeIdsFor(MyUser.class);
	}

}
