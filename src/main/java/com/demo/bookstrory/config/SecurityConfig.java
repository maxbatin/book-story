package com.demo.bookstrory.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.bookstrory.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private Environment env;
	
	@Autowired 
	private UserSecurityService userSecurityService;
	private BCryptPasswordEncoder passwordEncoder;
	
	private static final String[] PUBLIC_MATHCES = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/book/**",
			"/user/**"
	};
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests().
		antMatchers(PUBLIC_MATHCES).permitAll().anyRequest().authenticated();
	}
	
	@Autowired
	public void configureGlobal(AuthentificationManagerBuilder auth) throws  Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder);
		
	}

}
