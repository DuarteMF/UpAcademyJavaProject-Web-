package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.service.ProductService;

@ManagedBean(name="ProductView")
@RequestScoped
public class ProductView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private Product selectedProduct;
	
	@Inject ProductService productService;
 
    @PostConstruct
    public void init() {
    	products = productService.showProducts();
    			
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
    
    public Product getSelectedProduct() {
        return selectedProduct;
    }
 
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}
