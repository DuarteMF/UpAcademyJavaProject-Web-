package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.altar.jeeproject.model.EntityModel;
import io.altar.jeeproject.repository.EntityRepository;

public class EntityService<E extends EntityModel> {
	
	
	public List<E> showEntities(EntityRepository<E> entityList){
		List<E> list = new ArrayList<E>((Collection<E>)entityList.values());
		return list;
	}
	
	public void addEntity(EntityRepository<E> entityList, E entity){
		entityList.addToList(entity);
	}
	
	public void removeEntity(EntityRepository<E> entityList, E entity){
		entityList.removeElement(entity.getId());
	}
}
