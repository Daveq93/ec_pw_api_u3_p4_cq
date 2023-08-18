package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);
	
	public Estudiante consultarPorCedula(String cedula);

   public Estudiante actualizar(Estudiante estudiante);

   public Integer actualizarParcial(String cedulaActual, String cedulaNueva);
   
   public void eliminar(Integer id);
   
   public List<Estudiante> listarTodos();
   
   public Estudiante guardarEstudianteMetiType(Estudiante estudiante);

   public List<EstudianteTO> buscarTodosHATEOAS();
   
   
   
}
