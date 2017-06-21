package io.altar.jeeproject.repository;

import java.util.ArrayList;
import java.util.Collections;

import javax.faces.bean.ApplicationScoped;

import io.altar.jeeproject.model.Product;


@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> {
//	private static final ProductRepository INSTANCE = new ProductRepository();

	public ProductRepository() {}

//	public static ProductRepository getInstance() {
//		return INSTANCE;
//	}

	public void alterElement(Integer id, ArrayList<Integer> shelf, String name, Integer discount, Integer tax, Double price) {
		((Product) get(id)).setShelfIdLocation(shelf);
		((Product) get(id)).setName(name);		
		((Product) get(id)).setDiscount(discount);
		((Product) get(id)).setTax(tax);
		((Product) get(id)).setSalePrice(price);
	}
	
	public void addShelfLocation(Integer id, Integer shelfLocation) {
		ArrayList<Integer> currentShelfLocation = ((Product) get(id)).getShelfIdLocation();
		if(currentShelfLocation != null){
			currentShelfLocation.add(shelfLocation);
		}		
		((Product) get(id)).setShelfIdLocation(currentShelfLocation);
	}
	
	public void alterShelfLocation(Integer shelfOldProductId, Integer shelfNewProductfId, Integer shelfId) {
		if(shelfOldProductId!=shelfNewProductfId){
			if (shelfOldProductId != null) {
				ArrayList<Integer> oldProductShelfList = ((Product)  get(shelfOldProductId)).getShelfIdLocation();
				oldProductShelfList.remove(shelfId);
				((Product)  get(shelfOldProductId))
						.setShelfIdLocation(oldProductShelfList);
			}

			if (shelfNewProductfId != null) {
			ArrayList<Integer> newProductShelfList = ((Product)  get(shelfNewProductfId))
					.getShelfIdLocation();
				newProductShelfList.add(shelfId);
				Collections.sort(newProductShelfList);
				((Product)  get(shelfNewProductfId))
						.setShelfIdLocation(newProductShelfList);
			}
		}
	}
}