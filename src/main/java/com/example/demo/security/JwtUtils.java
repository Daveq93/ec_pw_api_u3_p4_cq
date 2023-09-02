package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtils {
	
	@Value("${app.jwt.secret}")
	private String jwtSecret;
	
	public boolean validateJWtToken(String token) {
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
