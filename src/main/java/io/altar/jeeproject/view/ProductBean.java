package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.service.ProductService;

@Named("ProductBean")
@RequestScoped
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Product selectedProduct = new Product();
	
	public Product getSelectedProduct() {
		return selectedProduct;
	}
	
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	private Product editedProduct = new Product();
	
	public Product getEditedProduct() {
		return editedProduct;
	}

	public void setEditedProduct(Product editedProduct) {
		this.editedProduct = editedProduct;
	}

	private Product newProduct = new Product();

	public Product getNewProduct() {
		return newProduct;
	}

	public void setNewProduct(Product newProduct) {
		this.newProduct = newProduct;
	}

	@Inject
	private ProductService productService;

	public List<Product> getProducts() {
		return productService.showEntities(productService.getProductRepository());
	}

	public String addProduct() {
		productService.addEntity(productService.getProductRepository(), newProduct);
		return null;
	}

	public String editProduct() {
		System.out.println(editedProduct.toString());
		productService.editProduct(editedProduct);
		return null;
	}

	public String deleteProduct() {
		System.out.println(selectedProduct.toString());
		productService.removeEntity(productService.getProductRepository(), selectedProduct);
		return null;
	}
	
	public void display(){
		System.out.println(selectedProduct.toString());
	}
	
//	private Integer editedProductId;
//	
//	public void passProduct(){
//		System.out.println(1);
//		editedProductId = selectedProduct.getId();
////		editedProduct = selectedProduct;
////		editedProduct.setId(selectedProduct.getId());
//	}
}
