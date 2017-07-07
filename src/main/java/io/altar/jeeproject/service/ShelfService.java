package io.altar.jeeproject.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.repository.ProductRepository;
import io.altar.jeeproject.repository.ShelfRepository;

@Named("ShelfService")
@ApplicationScoped
public class ShelfService extends EntityService<Shelf>{
	@Inject
	private ShelfRepository shelfList;
	
	public ShelfRepository getShelfRepository(){
		return shelfList;
	}
	
	public List<Shelf> showEntities(ShelfRepository shelfList){
		List<Shelf> list = shelfList.getDbElements();
		return list;
	}
	
	public void editEntity(int id, int location, int capacity, String productId, double rentalPrice){
		shelfList.alterInDb(id, location, capacity, productId, rentalPrice);
	}
	
//	public void editShelf(Shelf shelf){
//		shelfList.alterElement(shelf.getId(), shelf.getLocation(), shelf.getCapacity(), shelf.getProductID(), shelf.getLocationRentalPrice());
//	}
}
