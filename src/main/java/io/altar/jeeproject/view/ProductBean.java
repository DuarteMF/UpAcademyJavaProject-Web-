package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ProductService;
import io.altar.jeeproject.service.ShelfService;

@Named("ProductBean")
@RequestScoped
public class ProductBean implements Serializable {
	
	private int id;
	private int displayId;
	private String name;
	private List<Integer> shelfId;
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

	public List<Integer> getShelfId() {
		return shelfId;
	}

	public void setShelfId(List<String> shelfId) {
		this.shelfId = shelfId.stream().map(Integer::parseInt).collect(Collectors.toList());
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
	
	private Product displayedProduct = new Product();
	
	public Product getDisplayedProduct() {
		return displayedProduct;
	}

	public void setDisplayedProduct(Product displayedProduct) {
		this.displayedProduct = displayedProduct;
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
	
	@Inject
	private ShelfService shelfService;
	public List<Integer> existingShelves(){
		List<Shelf> existingShelvesList = shelfService.getShelfRepository().getDbElements();
		List<Integer> existingShelvesId = new ArrayList<>();
		for(Shelf shelf:existingShelvesList){
			existingShelvesId.add(shelf.getId());
		}
		return existingShelvesId;
	}
}
