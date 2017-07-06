package io.altar.jeeproject.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.EntityRepository;
import io.altar.jeeproject.repository.ProductRepository;

@Named("ProductService")
@RequestScoped
public class ProductService extends EntityService<Product>{
	@Inject
	private ProductRepository productList;
	
	public ProductRepository getProductRepository(){
		return productList;
	}
	
	public List<Product> showEntities(ProductRepository productList){
		List<Product> list = productList.getDbElements();
		return list;
	}
	
	public void editEntity(int id, String name, String shelfId, int discount, int tax, double price){
		productList.alterInDb(id, name, shelfId, discount, tax, price);
	}
	
//	public void editProduct(Product product){
//		productList.alterElement(product.getId(), product.getShelfIdLocation(), product.getName(), product.getDiscount(), product.getTax(), product.getSalePrice());
//	}
}