package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDateTime fechaNacimiento;
	
	private String provincia;
	
	
}
