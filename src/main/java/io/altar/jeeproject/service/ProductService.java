package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.repository.ProductRepository;

//@ManagedBean(name = "productService")
//@ApplicationScoped
public class ProductService {
	private ProductRepository productList = ProductRepository.getInstance();
	
	public List<Product> createProducts() {
        List<Product> list = new ArrayList<Product>();
        productList.addToList(new Product(null,"tomate",5,6,2.0));
        productList.addToList(new Product(null,"laranja",4,6,3.0));
        list = new ArrayList<Product>((Collection<Product>)productList.values());         
        return list;
    }
}
