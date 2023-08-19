package com.example.demo.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
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
		boolean flag = false;
		try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		flag = true;
		}catch(ExpiredJwtException e) {
			log.error("Token expirado: "+e.getMessage());
		}catch(SignatureException e) {
			log.error("Token invalido: "+e.getMessage());
		}
		return flag;
	}
	
	//obtener el nombre a partir del token
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
}
