package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Estudiante;

public interface IEstudianteRepo {

	public void insertarEstudiante(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	
	public Integer actualizarParcial(String cedulaActual, String cedulaNueva);


	public void borrar(Integer id);
	
	List<Estudiante> listarEstudiantes();

	public Estudiante insertarEstudianteMedia(Estudiante estudiante);
}
