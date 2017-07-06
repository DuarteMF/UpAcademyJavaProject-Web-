package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Product;
import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ShelfService;

@Named("ShelfBean")
@RequestScoped
public class ShelfBean implements Serializable{
	
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
    
    public String editShelf(){
		System.out.println(selectedShelf.toString());
		shelfService.editEntity(shelfService.getShelfRepository(), selectedShelf);
    	return null;
    }
    
    public String deleteShelf(){
    	shelfService.removeEntity(shelfService.getShelfRepository(), selectedShelf);
    	return null;
    }
}
