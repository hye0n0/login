package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.member.MemberServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form	//<security:form-loging
				.loginPage("/login")
				.passwordParameter("password")
				.usernameParameter("username")
				.loginProcessingUrl("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
//			.passwordManagement();
		;

		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.builder()  //.withDefaultPasswordEncoder()
//				.username("user")
//				.password("{bcrypt}$2a$04$q2lVd7PUoOlUh.nRcUZZwuMJ1/6FhHbIL.QQ0r8Ngd3EKtS61N4sS")
//				.roles("USER")
//				.build();
//		
//		UserDetails admin =
//			User.builder()  //.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("{bcrypt}$2a$04$q2lVd7PUoOlUh.nRcUZZwuMJ1/6FhHbIL.QQ0r8Ngd3EKtS61N4sS")
//				.roles("ADMIN")
//				.build();

//		return new InMemoryUserDetailsManager(user, admin);
		return new MemberServiceImpl();
	}
}
