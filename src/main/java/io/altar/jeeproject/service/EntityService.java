package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.altar.jeeproject.model.Entity;
import io.altar.jeeproject.repository.EntityRepository;

public class EntityService<E extends Entity> {
	@Inject
	private EntityRepository<E> entityRepository;
	
	public List<E> createEntities(){
		List<E> list = new ArrayList<>();
		return list;
	}
}
