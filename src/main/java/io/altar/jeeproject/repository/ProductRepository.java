package io.altar.jeeproject.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.altar.jeeproject.model.Product;
import net.bootsfaces.render.E;

@Named("productRepository")
@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> {

	public List<Product> getDbElements() {
		Query query = getDb().createQuery("FROM Product");
		List<Product> dbElements = (List<Product>) query.getResultList();
		return dbElements;
	}
	
	@Override
	@Transactional
	public void removeFromDb(Product product){
		Product productToRemove = getDb().find(Product.class, product.getId());
		getDb().remove(productToRemove);
	}
	
	@Transactional
	public void alterInDb(int id, String name, String shelfId, int discount, int tax, double price){
		Product dbProduct = getDb().find(Product.class, id);
		dbProduct.setName(name);
		dbProduct.setShelfIdLocation(shelfId);
		dbProduct.setDiscount(discount);
		dbProduct.setTax(tax);
		dbProduct.setSalePrice(price);
	}

	// public void alterElement(Integer id, String shelf, String name, Integer
	// discount, Integer tax, Double price) {
	// ((Product) get(id)).setShelfIdLocation(shelf);
	// ((Product) get(id)).setName(name);
	// ((Product) get(id)).setDiscount(discount);
	// ((Product) get(id)).setTax(tax);
	// ((Product) get(id)).setSalePrice(price);
	// }

	// public void addShelfLocation(Integer id, Integer shelfLocation) {
	// ArrayList<Integer> currentShelfLocation = ((Product)
	// get(id)).getShelfIdLocation();
	// if(currentShelfLocation != null){
	// currentShelfLocation.add(shelfLocation);
	// }
	// ((Product) get(id)).setShelfIdLocation(currentShelfLocation);
	// }
	//
	// public void alterShelfLocation(Integer shelfOldProductId, Integer
	// shelfNewProductfId, Integer shelfId) {
	// if(shelfOldProductId!=shelfNewProductfId){
	// if (shelfOldProductId != null) {
	// ArrayList<Integer> oldProductShelfList = ((Product)
	// get(shelfOldProductId)).getShelfIdLocation();
	// oldProductShelfList.remove(shelfId);
	// ((Product) get(shelfOldProductId))
	// .setShelfIdLocation(oldProductShelfList);
	// }
	//
	// if (shelfNewProductfId != null) {
	// ArrayList<Integer> newProductShelfList = ((Product)
	// get(shelfNewProductfId))
	// .getShelfIdLocation();
	// newProductShelfList.add(shelfId);
	// Collections.sort(newProductShelfList);
	// ((Product) get(shelfNewProductfId))
	// .setShelfIdLocation(newProductShelfList);
	// }
	// }
	// }
}