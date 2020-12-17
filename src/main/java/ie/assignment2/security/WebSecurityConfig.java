package ie.assignment2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
			.antMatchers("/css/**", "/", "/directors", "/movies/**", "/newuser", "/login/**").permitAll()
			.antMatchers("/newdirector", "/newmovie", "/api/**", "/myapi/**", "/editmovie").hasAnyRole("USER")
			.antMatchers("/delete/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated();
			
		http.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/log_me_in")
			.and()
				.logout()
					.logoutUrl("/log_me_out")
					.logoutSuccessUrl("/")
			.and()
				.httpBasic()
			.and()
				.exceptionHandling().accessDeniedPage("/403");
		
		http.csrf().disable();
	
	}
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
