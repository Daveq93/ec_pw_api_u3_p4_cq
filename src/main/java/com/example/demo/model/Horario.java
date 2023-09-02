package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@Column(name = "hrar_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seq_horario")
	@SequenceGenerator(name="seq_horario",sequenceName = "seq_horario",allocationSize = 1)
	private Integer id;
	
	@Column(name="hrar_codigo")
	private String codigo;
	
	@Column(name = "hrar_hora")
	private String hora;
	
	@Column(name = "hrar_paralelo")
	private String paralelo;
	
	@Column(name="hrar_carrera")
	private String carrera;
	
	@Column(name="hrar_nivel")
	private String nivel;
	

}
