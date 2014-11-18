package com.luciano.cargomgmt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luciano.cargomgmt.model.Cargo;

@Repository
public class CargoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void save(Cargo cargo) {
		if (cargo.getId() == null) {
			this.manager.persist(cargo);
		} else {
			this.manager.merge(cargo);
		}

	}

	public List<Cargo> allCargo() {
		try {
			return this.manager.createQuery("select c from Cargo c",
					Cargo.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Cargo findCargoById(Integer id) {
		try {
			return this.manager
					.createQuery(
							"select c from Cargo c where c.id = :id",
							Cargo.class)
					.setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void delete(Cargo cargo) {
		this.manager.remove(cargo);
		
	}
}
