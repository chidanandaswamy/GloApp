package com.GlobalApp.Authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@SpringBootApplication

public class AuthenticationApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}


        @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests()
				.antMatchers("/Authentication/user/save"
//						"/login",
//						"/swagger-ui/**",
//						"/v3/api-docs/**",
//						"user/registration",
//						"user/login/email/password",
//						"user/forgotPassword"
				).permitAll()
				.anyRequest().authenticated();
	}


}