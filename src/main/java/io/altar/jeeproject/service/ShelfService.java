package io.altar.jeeproject.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.repository.ShelfRepository;

@Named("ShelfService")
@ApplicationScoped
public class ShelfService extends EntityService<Shelf>{
	@Inject
	private ShelfRepository shelfList;
	
	public ShelfRepository getShelfRepository(){
		return shelfList;
	}
	
	public void editShelf(Shelf shelf){
		shelfList.alterElement(shelf.getId(), shelf.getLocation(), shelf.getCapacity(), shelf.getProductID(), shelf.getLocationRentalPrice());
	}
}
