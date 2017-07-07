package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ProductService;
import io.altar.jeeproject.service.ShelfService;

@Named("ShelfBean")
@RequestScoped
public class ShelfBean implements Serializable{
	
	private int id;
	private int displayID;
	private int location;
	private int capacity;
	private String productId;
	private double rentalprice;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisplayID() {
		return displayID;
	}

	public void setDisplayID(int displayID) {
		this.displayID = displayID;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getRentalprice() {
		return rentalprice;
	}

	public void setRentalprice(double rentalprice) {
		this.rentalprice = rentalprice;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Shelf selectedShelf = new Shelf();
	
	public Shelf getSelectedShelf() {
        return selectedShelf;
    }
 
    public void setSelectedShelf(Shelf selectedShelf) {
        this.selectedShelf = selectedShelf;
    }
    
	private Shelf editedShelf = new Shelf();

	public Shelf getEditedShelf() {
		return editedShelf;
	}

	public void setEditedProduct(Shelf editedShelf) {
		this.editedShelf = editedShelf;
	}
	
	private Shelf newShelf = new Shelf();
	
	public Shelf getNewShelf() {
		return newShelf;
	}

	public void setNewShelf(Shelf newShelf) {
		this.newShelf = newShelf;
	}

	@Inject
	private ShelfService shelfService;
     
    public List<Shelf> getShelves() {
        return shelfService.showEntities(shelfService.getShelfRepository());
    }
    
    public String addShelf(){
    	shelfService.addEntity(shelfService.getShelfRepository(), newShelf);
    	return null;
    }
    
//    public String editShelf(){
//		System.out.println(selectedShelf.toString());
//		shelfService.editEntity(shelfService.getShelfRepository(), selectedShelf);
//    	return null;
//    }
    
    public String editShelf(){
		shelfService.editEntity(id, location, capacity, productId, rentalprice);
    	return null;
    }
	
    
    public String deleteShelf(){
    	shelfService.removeEntity(shelfService.getShelfRepository(), selectedShelf);
    	return null;
    }
    
    @Inject
	private ProductService productService;
	public List<Integer> existingProducts(){
		List<Product> existingProductsList = productService.getProductRepository().getDbElements();
		List<Integer> existingProductsId = new ArrayList<>();
		existingProductsId.add(0);
		for(Product product:existingProductsList){
			existingProductsId.add(product.getId());
		}
		return existingProductsId;
	}
}
