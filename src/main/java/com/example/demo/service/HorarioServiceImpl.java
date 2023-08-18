package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Horario;
import com.example.demo.repository.IHorarioRepo;

@Service
public class HorarioServiceImpl implements IHorarioService {
	
	@Autowired
	private IHorarioRepo horarioRepo;

	@Override
	public Horario guardar(Horario horario) {
		// TODO Auto-generated method stub
     return this.horarioRepo.insertarHorario(horario);
	}

	@Override
	public Optional<Horario>  buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.horarioRepo.buscarPorCodigo(codigo));
	}

	@Override
	public Horario actualizar(Horario horario) {
		// TODO Auto-generated method stub
		return this.horarioRepo.actualizarHorario(horario);
	}

	@Override
	public Integer actualizarCarrera(String codigo, String carrera) {
		// TODO Auto-generated method stub
		return this.horarioRepo.actualizarCarrera(codigo, carrera);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
            this.horarioRepo.eliminarHorario(id);
	}

	@Override
	public List<Horario> todos() {
		// TODO Auto-generated method stub
		return this.horarioRepo.listarTodos();
	}

	@Override
	public Boolean existByCode(String codigo) {
		// TODO Auto-generated method stub
		return this.horarioRepo.existByCode(codigo);
	}

	@Override
	public Boolean existById(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepo.existById(id);
	}

}
