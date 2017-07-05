package io.altar.jeeproject.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.model.Shelf;

@Named("shelfRepository")
@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> {
	
	public List<Shelf> getDbElements() {
		Query query = getDb().createQuery("FROM Shelf");
		List<Shelf> dbElements = (List<Shelf>) query.getResultList();
		return dbElements;
	}
	
	@Override
	@Transactional
	public void removeFromDb(Shelf shelf){
		Shelf shelfToRemove = getDb().find(Shelf.class, shelf.getId());
		getDb().remove(shelfToRemove);
	}

//	public void alterElement(Integer id, Integer location, Integer capacity, Integer productID, Double price) {
//		((Shelf) get(id)).setLocation(location);
//		((Shelf) get(id)).setCapacity(capacity);
//		((Shelf) get(id)).setProductID(productID);
//		((Shelf) get(id)).setLocationRentalPrice(price);
//	}
//	
//	public void toggleProductPresent(Integer id, Integer productID) {
//		if(((Shelf) get(id)).getProductID()==null){
//			((Shelf) get(id)).setProductID(productID);
//		}else{
//			((Shelf) get(id)).setProductID(null);
//		}
//	}
}
