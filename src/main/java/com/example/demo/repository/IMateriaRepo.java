package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Materia;
import com.example.demo.service.to.MateriaTO;


public interface IMateriaRepo {

	
	
	public void insertarMateria(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);
	
	
	public List<Materia> buscarPorCedulaEstudiante(String cedulaEstudiante);

    public List<Materia> listarMaterias();
	
	
}
