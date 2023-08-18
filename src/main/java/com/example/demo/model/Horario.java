package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
