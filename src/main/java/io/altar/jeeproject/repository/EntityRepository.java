package io.altar.jeeproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.altar.jeeproject.model.EntityModel;

public class EntityRepository<E extends EntityModel> {
	@PersistenceContext(unitName="database")
	private EntityManager em;
	
	public EntityManager getDb(){
		return em;
	}
	
	@Transactional
	public void addToDb(E entity){
		em.persist(entity);
	}
	
	@Transactional
	public void removeFromDb(E entity){}
	
	@Transactional
	public void alterInDb(E newEntity){
		em.merge(newEntity);
	}
}


