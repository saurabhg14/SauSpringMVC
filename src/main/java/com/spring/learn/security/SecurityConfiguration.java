package com.spring.learn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("Saurabh1").password("Password")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/my-web").permitAll()
			.antMatchers("/*my-web*/**").access("hasRole('USER')")//.and()
			.anyRequest().authenticated()
            .and().formLogin().defaultSuccessUrl("/my-web/welcome").permitAll()
            .failureUrl("/error")
            .and().httpBasic();
			
			//.and().formLogin().loginProcessingUrl("/my-web/welcome");
		

	}
}