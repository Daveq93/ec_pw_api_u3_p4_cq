package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="estudiante")
@JsonIgnoreProperties(value="materias")//para omitir la dependencia ciclica
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seq_estudiante")
	@SequenceGenerator(name="seq_estudiante",sequenceName = "seq_estudiante",allocationSize = 1)
	private Integer id;
	@Column(name = "estu_cedula")
	private String cedula;
	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name="estu_provincia")
	private String provincia;
	
	@OneToMany(mappedBy = "estudiante",fetch = FetchType.LAZY)
	private List<Materia> materias;

//	@Override
//	public String toString() {
//		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
//				+ ", fechaNacimiento=" + fechaNacimiento + ", provincia=" + provincia + "]";
//	}
	
	
}
