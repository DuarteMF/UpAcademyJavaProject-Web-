package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.service.ProductService;

@ManagedBean(name="ProductView")
@ViewScoped
public class ProductView implements Serializable {
	
	private List<Product> products;
	
	@ManagedProperty(value="#{productService}")
    private ProductService productService;
 
    @PostConstruct
    public void init() {
    	products = productService.createProducts();
    			
    }
     
    public List<Product> getProducts() {
        return products;
    }
    
    public ProductService getProductService() {
        return productService;
    }
 
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}
