package io.altar.jeeproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.ProductRepository;

@Named("productService")
@RequestScoped
public class ProductService extends EntityService<Product>{
//public class ProductService{
	@Inject
	private ProductRepository productList;
//	private ProductRepository productList = ProductRepository.getInstance();
	
	public ProductRepository getProductRepository(){
		return productList;
	}
	
	public void editProduct(Product product){
		productList.alterElement(product.getId(), product.getShelfIdLocation(), product.getName(), product.getDiscount(), product.getTax(), product.getSalePrice());
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
