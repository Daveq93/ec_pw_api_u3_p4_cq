package com.example.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HorarioRepoImpl implements IHorarioRepo {

	private static final Logger LOG = LoggerFactory.getLogger(HorarioRepoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public Horario insertarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.em.persist(horario);
		return horario;
	}

	@Override
	public Horario buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQ = this.em.createQuery("SELECT h FROM Horario h WHERE h.codigo=:codigo",
				Horario.class);

		return myQ.setParameter("codigo", codigo).getSingleResult();
	}

	@Override
	public Horario actualizarHorario(Horario horario) {
		return this.em.merge(horario);
	}

	@Override
	public Integer actualizarCarrera(String codigo, String carrera) {
		// TODO Auto-generated method stub
		Query myQ = this.em.createQuery("UPDATE Horario h SET h.carrera =: carrera Where h.codigo=:codigo");
		return myQ.setParameter("carrera", carrera).setParameter("codigo", codigo).executeUpdate();
	}

	@Override
	public void eliminarHorario(Integer id) {
		this.em.remove(this.em.find(Horario.class, id));
	}

	@Override
	public List<Horario> listarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQ = this.em.createQuery("SELECT h FROM Horario h", Horario.class);
		return myQ.getResultList();
	}

	@Override
	public Boolean existByCode(String codigo) {
		Boolean flag = false;
		try {
			TypedQuery<Horario> myQ = this.em.createQuery("SELECT h FROM Horario h WHERE h.codigo=:codigo",
					Horario.class);
			myQ.setParameter("codigo", codigo).getSingleResult();
			flag = true;
		} catch (NoResultException e) {
			LOG.error(e.getMessage());
		}
		return flag;
	}

	@Override
	public Boolean existById(Integer id) {
		Boolean flag = false;
		
		try {
		this.em.find(Horario.class, id);
			flag = true;
		} catch (NoResultException e) {
			LOG.error(e.getMessage());
		}
		return flag;
	}

}
