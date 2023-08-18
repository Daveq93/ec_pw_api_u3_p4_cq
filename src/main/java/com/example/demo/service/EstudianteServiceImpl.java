package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertarEstudiante(estudiante);
		
	}

	@Override
	public Estudiante actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
	return	this.estudianteRepo.actualizarEstudiante(estudiante);
	}

	@Override
	public Integer actualizarParcial(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.actualizarParcial(cedulaActual, cedulaNueva);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.borrar(id);
	}

	@Override
	public List<Estudiante> listarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepo.listarEstudiantes();
	}

	@Override
	public Estudiante guardarEstudianteMetiType(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.insertarEstudianteMedia(estudiante);
	}

	@Override
	public List<EstudianteTO> buscarTodosHATEOAS() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepo.listarEstudiantes();
		
		List<EstudianteTO> listaTO = lista.parallelStream().map(e->{
			EstudianteTO et = new EstudianteTO();
			et.setApellido(e.getApellido());
			et.setCedula(e.getCedula());
			et.setFechaNacimiento(e.getFechaNacimiento());
			et.setId(e.getId());
			et.setNombre(e.getNombre());
			et.setProvincia(e.getProvincia());
			return et;
		} ).collect(Collectors.toList());
		
		return listaTO;
	}

}
