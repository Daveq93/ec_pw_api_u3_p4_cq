package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

//import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;

	// Intercepta
	// se debe ejecutar antes de que se ejecute el api
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//validacion de si el token es valido
		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && this.jwtUtils.validateJWtToken(jwt)) {
				// Como es valido el token, tengo que autenticar el ingreso
				String nombre = this.jwtUtils.getUserNameFromJwtToken(jwt);

				/// Atenticamos
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(nombre,
						null, new ArrayList<>());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// seteamos la autenticacion en la sesion
				SecurityContextHolder.getContext().setAuthentication(authentication);

			}
		} catch (Exception e) {
			log.error("No se pudo realizar la autenticacion con el token enviado: {}", e.getMessage());
		}
		filterChain.doFilter(request, response);// procese lo que hemos camellado
	}
	// el token se debe enviar en un header llamado Autorized
	// el valor del token debe venir con la siguiente nomenclatura
	// Bearer ...........token.........

	
	
	//metodo para obtener el token valido
	private String parseJwt(HttpServletRequest request) {
		String valorCompleto = request.getHeader("Authorization");

		if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer ")) {
			return valorCompleto.substring(7, valorCompleto.length());
		}
		return null;
	}

}
