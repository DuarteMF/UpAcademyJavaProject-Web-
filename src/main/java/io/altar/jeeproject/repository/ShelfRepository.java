package io.altar.jeeproject.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import io.altar.jeeproject.model.Shelf;

@Named("shelfRepository")
@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> {

	public void alterElement(Integer id, Integer location, Integer capacity, Integer productID, Double price) {
		((Shelf) get(id)).setLocation(location);
		((Shelf) get(id)).setCapacity(capacity);
		((Shelf) get(id)).setProductID(productID);
		((Shelf) get(id)).setLocationRentalPrice(price);
	}
	
	public void toggleProductPresent(Integer id, Integer productID) {
		if(((Shelf) get(id)).getProductID()==null){
			((Shelf) get(id)).setProductID(productID);
		}else{
			((Shelf) get(id)).setProductID(null);
		}
	}
}
