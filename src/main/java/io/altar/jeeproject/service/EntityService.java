package io.altar.jeeproject.service;

import java.util.List;

import io.altar.jeeproject.model.EntityModel;
import io.altar.jeeproject.repository.EntityRepository;

public class EntityService<E extends EntityModel> {
	
	
	public List<E> showEntities(EntityRepository<E> entityList){
		List<E> list = entityList.getDbElements();
		return list;
	}
	
	public void addEntity(EntityRepository<E> entityList, E entity){
		entityList.addToDb(entity);
	}
	
	public void removeEntity(EntityRepository<E> entityList, E entity){
		entityList.removeFromDb(entity);
	}
	
	public void editEntity(EntityRepository<E> entityList, E entity){
		entityList.alterInDb(entity);
	}
}
