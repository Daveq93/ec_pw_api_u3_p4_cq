package com.example.demo.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class AuthEntriPointJwt implements AuthenticationEntryPoint{

	private static final Logger LOG = LoggerFactory.getLogger(AuthEntriPointJwt.class);
	
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOG.error("----------------------- Unatorized Error {}",authException.getMessage());
		LOG.error(request.getServletPath());
	}



}
