package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Horario;

public interface IHorarioService {

public Horario guardar(Horario horario);
	
	public Optional<Horario> buscarPorCodigo(String codigo);
	
	public Horario actualizar(Horario horario);
	
	public Integer actualizarCarrera(String codigo, String carrera);
		
	public void eliminar(Integer id);
	
	public List<Horario> todos();
	
	public Boolean existByCode(String codigo);
	
	public Boolean existById(Integer id);
}
