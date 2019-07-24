package com.lms.svc.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.lms.svc.common.repository.LmsAuthenticationProvider;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class LmsSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String USER_SERVICE_API = "**/api/us/users/";
	private static final String BOOK_SERVICE_API = "**/api/bs/books/";
	
	private LmsAuthenticationProvider lmsAuthenticationProvider;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Adding provider...............");
		auth.authenticationProvider(lmsAuthenticationProvider);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("Adding patterns...............");
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, USER_SERVICE_API).authenticated()
			.antMatchers(USER_SERVICE_API + "{userId}").hasRole("A")
			.antMatchers(HttpMethod.POST, USER_SERVICE_API).permitAll()
			.antMatchers(HttpMethod.POST, "**/api/us/login/").permitAll()
			
			.antMatchers(HttpMethod.GET, BOOK_SERVICE_API).hasRole("B")
			.antMatchers(HttpMethod.POST, BOOK_SERVICE_API).hasRole("A")
			.antMatchers(HttpMethod.GET, BOOK_SERVICE_API + "{bookId}").hasRole("B")
			.antMatchers(HttpMethod.DELETE, BOOK_SERVICE_API + "{bookId}").hasRole("A")
			.antMatchers(HttpMethod.PUT, BOOK_SERVICE_API + "{bookId}").hasRole("A")
			.antMatchers(HttpMethod.POST, BOOK_SERVICE_API + "upload").hasRole("A")
			.antMatchers(HttpMethod.POST, BOOK_SERVICE_API + "{bookId}/inc/{count}").hasRole("A")
			.antMatchers(HttpMethod.POST, BOOK_SERVICE_API + "{bookId}/dec/{count}").hasRole("A")
			.and()
			.httpBasic();
	}
}
