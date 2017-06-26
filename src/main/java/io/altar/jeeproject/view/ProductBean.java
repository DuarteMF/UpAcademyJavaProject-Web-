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
	
	private Product selectedProduct;
	
	public Product getSelectedProduct() {
		return selectedProduct;
	}
	
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
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
	
//	private static List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return productService.showEntities(productService.getProductRepository());
//		return productService.showProducts();
	}

//	public static List<Product> getProducts() {
//		return products;
//	}
//
//	public static void setProducts(List<Product> products) {
//		ProductBean.products = products;
//	}
//
//	public Product getSelectedProduct() {
//		return selectedProduct;
//	}


	public String addProduct() {
//		products.add(new Product());
		productService.addEntity(productService.getProductRepository(), newProduct);
//		productService.addProduct(newProduct);
		return null;
	}

	public String editProduct() {
		System.out.println(2);
		return null;
	}

	public String deleteProduct() {
		System.out.println(3);
		productService.removeEntity(productService.getProductRepository(), selectedProduct);
//		productService.removeProduct(selectedProduct);
//		products.remove(selectedProduct);
		return null;
	}
}