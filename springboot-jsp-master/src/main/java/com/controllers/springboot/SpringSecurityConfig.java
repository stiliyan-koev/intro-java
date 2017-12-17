package com.controllers.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/employee").hasRole("EMPLOYEE").antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/employer").hasRole("EMPLOYER").and().formLogin().successHandler(successHandler)
				.loginPage("/login").and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("mariqnTheBoss").password("boss").roles("EMPLOYER");
		auth.inMemoryAuthentication().withUser("iliya").password("iliya").roles("EMPLOYER");

		auth.inMemoryAuthentication().withUser("admin2").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

}