package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.ProductRepository;

@ManagedBean(name = "productService")
@ApplicationScoped
public class ProductService {
	private ProductRepository productList = ProductRepository.getInstance();
	
	public List<Product> showProducts() {
        List<Product> list = new ArrayList<Product>((Collection<Product>)productList.values());         
        return list;
    }
	
	public void addProducts(){
		productList.addToList(new Product(null ,"teste",1,6,5.0));
	}
}
