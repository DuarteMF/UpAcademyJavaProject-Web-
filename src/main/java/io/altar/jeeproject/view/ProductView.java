package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.service.ProductService;

@ManagedBean(name = "ProductView")
@RequestScoped
public class ProductView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private List<Product> products;
	private Product selectedProduct;

	@Inject
	static ProductService productService;

	private String productName = "";
	private ArrayList<Integer> productShelfIdLocation;
	private Integer productDiscount;
	private Integer productTax;
	private Double productPrice;

	// @PostConstruct
	// public void init() {
	// products = productService.showProducts();
	// }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList<Integer> getProductShelfIdLocation() {
		return productShelfIdLocation;
	}

	public void setProductShelfIdLocation(ArrayList<Integer> productShelfIdLocation) {
		this.productShelfIdLocation = productShelfIdLocation;
	}

	public Integer getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Integer productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Integer getProductTax() {
		return productTax;
	}

	public void setProductTax(Integer productTax) {
		this.productTax = productTax;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	// private static final List<Product> products =
	// productService.showProducts();
	private static final List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		// this.productService = productService;
		ProductView.productService = productService;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public String addProduct() {
		// productService.addProduct(product);
		products.add(new Product(this.productShelfIdLocation, this.productName, this.productDiscount, this.productTax,
				this.productPrice));
		return null;
	}

	public String editProduct() {
		return null;
	}

	public String deleteProduct() {
		products.remove(selectedProduct);
		return null;
	}
}
