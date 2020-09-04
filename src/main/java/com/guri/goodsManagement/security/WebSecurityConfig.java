package com.guri.goodsManagement.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService; 

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();

		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("POST", "PUT", "GET", "DELETE", "OPTIONS"));
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
		
//		ERROR EN ROLES...
		
//				.antMatchers(HttpMethod.POST, "/user/**").hasAuthority("ADMIN")
//				.antMatchers(HttpMethod.PUT, "/user/**").hasAuthority("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ADMIN")
//				.antMatchers(HttpMethod.GET, "/user/**").hasAuthority("ADMIN")
//				
//				.antMatchers(HttpMethod.POST, "/priceReduction/**").authenticated()
//				.antMatchers(HttpMethod.PUT, "/priceReduction/**").authenticated()
//				.antMatchers(HttpMethod.DELETE, "/priceReduction/**").authenticated()
//				.antMatchers(HttpMethod.GET, "/priceReduction/**").authenticated()
//				
//				.antMatchers(HttpMethod.POST, "/product/**").authenticated()
//				.antMatchers(HttpMethod.PUT, "/product/**").authenticated()
//				.antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority("ADMIN")
//				.antMatchers(HttpMethod.GET, "/product/**").authenticated()
//				
//				.antMatchers(HttpMethod.POST, "/report/**").authenticated()
//				.antMatchers(HttpMethod.PUT, "/report/**").authenticated()
//				.antMatchers(HttpMethod.DELETE, "/report/**").authenticated()
//				.antMatchers(HttpMethod.GET, "/report/**").authenticated()
//
//				.antMatchers(HttpMethod.POST, "/supplier/**").authenticated()
//				.antMatchers(HttpMethod.PUT, "/supplier/**").authenticated()
//				.antMatchers(HttpMethod.DELETE, "/supplier/**").authenticated()
//				.antMatchers(HttpMethod.GET, "/supplier/**").authenticated()
//				
//				.antMatchers(HttpMethod.POST, "/ticket/**").authenticated()
//				.antMatchers(HttpMethod.PUT, "/ticket/**").authenticated()
//				.antMatchers(HttpMethod.DELETE, "/ticket/**").authenticated()
//				.antMatchers(HttpMethod.GET, "/ticket/**").authenticated()
//				
//				.and().httpBasic();
	}
}