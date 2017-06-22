package io.altar.jeeproject.repository;

import io.altar.jeeproject.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}

	public void alterElement(Integer id, Integer location, Integer capacity, Integer productID, Double price) {
		((Shelf) ShelfRepository.getInstance().get(id)).setLocation(location);
		((Shelf) ShelfRepository.getInstance().get(id)).setCapacity(capacity);
		((Shelf) ShelfRepository.getInstance().get(id)).setProductID(productID);
		((Shelf) ShelfRepository.getInstance().get(id)).setLocationRentalPrice(price);
	}
	
	public void toggleProductPresent(Integer id, Integer productID) {
		if(((Shelf) ShelfRepository.getInstance().get(id)).getProductID()==null){
			((Shelf) ShelfRepository.getInstance().get(id)).setProductID(productID);
		}else{
			((Shelf) ShelfRepository.getInstance().get(id)).setProductID(null);
		}
	}
}
