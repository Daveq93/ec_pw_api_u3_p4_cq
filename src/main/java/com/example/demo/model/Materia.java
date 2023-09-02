package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@Column(name = "mate_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mseq_materia")
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	private Integer id;

	@Column(name = "mate_codigo")
	private String codigo;

	@Column(name = "mate_nombre")
	private String nombre;

	@Column(name = "mate_creditos")
	private Integer creditos;

	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;

	// Get and set generado por lombok

}
