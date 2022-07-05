package com.flight.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.flight.service.FlightUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	FlightUserDetailsService flightUserDetailsService;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// All requests send to the Web Server request must be authenticated
		http.authorizeRequests().anyRequest().authenticated();

		// Use AuthenticationEntryPoint to authenticate user/password
		http.httpBasic().authenticationEntryPoint(authEntryPoint);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

// Below is required for JDBC authentication, with user roles.
	@Bean
	public DaoAuthenticationProvider authententicationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(flightUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setAuthoritiesMapper(mapper());
		return daoAuthenticationProvider;
	}

	@Bean
	GrantedAuthoritiesMapper mapper() {

		SimpleAuthorityMapper simpleAuthorityMapper = new SimpleAuthorityMapper();
		simpleAuthorityMapper.setConvertToUpperCase(true);
		simpleAuthorityMapper.setDefaultAuthority("USER");
		return simpleAuthorityMapper;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authententicationProvider());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		// encoded 'password' as password.
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}