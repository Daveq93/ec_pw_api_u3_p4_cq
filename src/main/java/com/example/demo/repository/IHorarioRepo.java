package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Horario;

public interface IHorarioRepo {

	public Horario insertarHorario(Horario horario);
	
	public Horario buscarPorCodigo(String codigo);
	
	public Horario actualizarHorario(Horario horario);
	
	public Integer actualizarCarrera(String codigo, String carrera);
	
	
	public void eliminarHorario(Integer id);
	
	public List<Horario> listarTodos();
	
	public Boolean existByCode(String codigo);
	
	public Boolean existById(Integer id);
}
