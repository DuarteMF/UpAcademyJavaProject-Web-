package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ReorderEvent;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.service.ProductService;

@ManagedBean(name="ProductView")
@ViewScoped
public class ProductView implements Serializable {
	
	private List<Product> products;
	private Product selectedProduct;
	
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
    
    public Product getSelectedProduct() {
        return selectedProduct;
    }
 
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved", "From: " + event.getFromIndex() + ", To:" + event.getToIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
