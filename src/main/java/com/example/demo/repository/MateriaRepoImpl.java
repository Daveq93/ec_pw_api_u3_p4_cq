package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Materia;
import com.example.demo.service.to.MateriaTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager em;
 
	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.em.persist(materia);
		
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ = this.em.createQuery("Select m from Materia m where m.codigo=:codigoM", Materia.class);
		return myQ.setParameter("codigoM", codigo).getSingleResult();
	}

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedulaEstudiante) {
		// TODO Auto-generated method stub
		//select m from Materia m where m.estudiante.cedula=:cedula
		TypedQuery<Materia> myQ = this.em.createQuery("select m from Materia m where m.estudiante.cedula=:cedula",Materia.class);
		List<Materia> materias =myQ.setParameter("cedula", cedulaEstudiante).getResultList();
		materias.size();
		return materias;
	}


	@Override
	public List<Materia> listarMaterias() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ = this.em.createQuery("select m from Materia m",Materia.class);
		return myQ.getResultList();
	}

	

}
