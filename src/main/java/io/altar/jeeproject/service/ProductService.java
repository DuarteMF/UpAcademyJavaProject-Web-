package io.altar.jeeproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.ProductRepository;

@Named("ProductService")
@RequestScoped
public class ProductService extends EntityService<Product>{
	@Inject
	private ProductRepository productList;
	
	public ProductRepository getProductRepository(){
		return productList;
	}
	
//	public void editProduct(Product product){
//		productList.alterElement(product.getId(), product.getShelfIdLocation(), product.getName(), product.getDiscount(), product.getTax(), product.getSalePrice());
//	}
}