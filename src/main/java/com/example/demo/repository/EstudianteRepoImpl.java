package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;



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
	public Estudiante insertarEstudiante(Estudiante estudiante) {
		this.em.persist(estudiante);
		return estudiante;
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
