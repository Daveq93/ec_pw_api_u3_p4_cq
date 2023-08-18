package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
*/
@Slf4j
@Component
public class JwtUtils {
	
	@Value("${app.jwt.secret}")
	private String jwtSecret;
	@Value("${app.jwt.expiration}")
	private long jwtExpiration ;

	/*public String generateJWTToken( String username) {
        log.info("Semilla: " + jwtSecret + " Tiempo: " + jwtExpiration);
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
    }*/
	
	/*
	public String generateJwtToken(String nombre) {
		log.info("secret: "+this.jwtSecret + " expiration: "+this.jwtExpiration);
		
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + this.jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
	}*/
	
	
	public boolean validateJWtToken(String token) {
		//Jwts.parset().setSigningKey(jwtSecret).parseClaimsJws(token);
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		return true;
	}
}
