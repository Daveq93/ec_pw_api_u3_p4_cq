package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codigo;
	
	private String nombre;

	private String numeroCedula;

}
