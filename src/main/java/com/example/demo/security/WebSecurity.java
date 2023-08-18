package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.uce.edu.service.UsuarioServiceImpl;

@Configuration
public class WebSecurity {

//	@Autowired
//	private UsuarioServiceImpl userService;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthEntriPointJwt unauthorizedHandler;
	
	/*
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
                .cors(c->{
                	c.disable();
                })
                .csrf(csr->{
                	csr.disable();
                })
                .exceptionHandling(handling -> handling.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    auth.antMatchers("/tokens/obtener/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .authenticationProvider(authenticationProvider())                
                .build();
			
	}*/
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	   http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and().authorizeRequests().anyRequest().authenticated();
	   ;
	 
	   http.addFilterBefore(this.authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	   
	   return http.build();
	}
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return  new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();	
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(this.passwordEncoder());
//		return authProvider;
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		
//		return authenticationConfiguration.getAuthenticationManager();
//	}
}

//sesion es un espacio donde se guardan los datos de la sesion
