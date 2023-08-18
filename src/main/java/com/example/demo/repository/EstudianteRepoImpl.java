package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQ = this.em.createQuery("Select e from Estudiante e where e.cedula =: datoCedula",Estudiante.class);
		Estudiante es =myQ.setParameter("datoCedula", cedula).getSingleResult();
		return es;
	}

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		this.em.persist(estudiante);
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.em.merge(estudiante);
	}

	@Override
	public Integer actualizarParcial(String cedulaActual, String cedulaCondicion) {
		// TODO Auto-generated method stub
		Query myQ =this.em.createQuery("UPDATE Estudiante e SET e.cedula =: cedulaNueva Where e.cedula=:cedulaCondicion");
	 return   myQ.setParameter("cedulaNueva", cedulaActual).setParameter("cedulaCondicion", cedulaCondicion).executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		 
		this.em.remove(this.buscarPorId(id));
	}

	
	public Estudiante buscarPorId(Integer id) {
		return this.em.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> listarEstudiantes() {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQ = this.em.createQuery("Select e from Estudiante e",Estudiante.class);
		return myQ.getResultList();
	}

	@Override
	public Estudiante insertarEstudianteMedia(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.em.persist(estudiante);
		return estudiante;
	}
}
