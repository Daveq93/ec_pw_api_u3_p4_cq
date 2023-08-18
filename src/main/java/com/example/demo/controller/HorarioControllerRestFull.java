package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFull {
	
	private static final Logger LOG = LoggerFactory.getLogger(HorarioControllerRestFull.class);
	
	@Autowired
	private IHorarioService horarioService;

	@GetMapping(path="/{codigo}")
	public ResponseEntity<Horario> buscarHoraioPorCodigo(@PathVariable(name="codigo")String codigo) {
		Optional<Horario> horario = this.horarioService.buscarPorCodigo(codigo);
		if(horario.isPresent())
			return ResponseEntity.ok(horario.get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Horario> guardarHorario(@RequestBody Horario horario){
		return ResponseEntity.ok(this.horarioService.guardar(horario));
	}
	
	@PutMapping
	public ResponseEntity<Horario> actualizarHorario(@RequestBody Horario horario){
		if(horario.getId()==null) {
			LOG.warn("Tratando de actualzar sin ingresar el id");
			return ResponseEntity.badRequest().build();
		}
		if(!this.horarioService.existById(horario.getId())) {
			LOG.warn("El id ingresado no existe");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.horarioService.actualizar(horario));
	}
	
	
	@PatchMapping(path="/{codigo}")
	public ResponseEntity<Integer> actualizarCarrera(@RequestBody Horario horario,@PathVariable(name="codigo")String codigo){
		if(codigo ==null) {
			LOG.warn("Tratando de actualzar sin ingresar el codigo");
			return ResponseEntity.badRequest().build();
		}
		if(!this.horarioService.existByCode(codigo)) {
			LOG.warn("El codigo ingresado no existe");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.horarioService.actualizarCarrera(codigo, horario.getCarrera()));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Horario> delete(@PathVariable(name="id")Integer id){
		if(!this.horarioService.existById(id)) {
			LOG.warn("No existe registro con el id ingresado");
			return ResponseEntity.notFound().build();
		}
		this.horarioService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public List<Horario> todos(){
		return this.horarioService.todos();
	}
}
