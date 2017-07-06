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
	
	private int id;
	private int displayId;
	private String name;
	private String shelfId;
	private int discount;
	private int tax;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDisplayId() {
		return displayId;
	}

	public void setDisplayId(int displayId) {
		this.displayId = displayId;
	}

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

//	public String editProduct() {
//		System.out.println(editedProduct.toString());
//		productService.editEntity(productService.getProductRepository(), editedProduct);
//		return null;
//	}
	
	public String editProduct() {
		productService.editEntity(id, name, shelfId, discount, tax, price);
		return null;
	}

	public String deleteProduct() {
		productService.removeEntity(productService.getProductRepository(), selectedProduct);
		return null;
	}
}
