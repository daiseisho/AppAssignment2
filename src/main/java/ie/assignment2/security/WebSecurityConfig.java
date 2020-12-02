package ie.assignment2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**","/").permitAll()
		.antMatchers("/directors").hasAnyRole("ADMIN","USER")
		.antMatchers("/movies").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		
		
		
		
	}
	
	@Bean
	protected UserDetailsService userDetailsDervice() {
		
		String encodedPassword = passwordEncoder().encode("password");
		
		String adminpassword=passwordEncoder().encode("admin12345");
		
		UserDetails user1= User
				.withUsername("user")
				.password(encodedPassword)
				.roles("USER")
				.build();
		
		UserDetails user2=User
				.withUsername("admin")
				.password(adminpassword)
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}


}
