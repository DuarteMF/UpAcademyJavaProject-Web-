package io.altar.jeeproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.ProductRepository;

@Named("productService")
@RequestScoped
public class ProductService extends EntityService<Product>{
	@Inject
	private ProductRepository productList;
	
	public ProductRepository getProductRepository(){
		return productList;
	}
	
//	public List<Product> showProducts() {
//        List<Product> list = new ArrayList<Product>((Collection<Product>)productList.values());         
//        return list;
//    }
//	
//	public void addProduct(Product product){
//		productList.addToList(product);
//	}
//	
//	public void removeProduct(Product product){
//		productList.removeElement(product.getId());
//	}
}
