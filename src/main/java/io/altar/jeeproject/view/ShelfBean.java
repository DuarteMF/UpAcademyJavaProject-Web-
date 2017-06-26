package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ShelfService;

@Named("ShelfBean")
@RequestScoped
public class ShelfBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Shelf> shelves;
	private Shelf selectedShelf;
	private Shelf newShelf = new Shelf();
	
	@Inject ShelfService shelfService;
 
    @PostConstruct
    public void init() {
    	shelves = shelfService.showEntities(shelfService.getShelfRepository());    			
    }
     
    public List<Shelf> getShelves() {
        return shelves;
    }
    
    public ShelfService getShelfService() {
        return shelfService;
    }
 
    public void setShelfService(ShelfService shelfService) {
        this.shelfService = shelfService;
    }
    
    public Shelf getSelectedShelf() {
        return selectedShelf;
    }
 
    public void setSelectedShelf(Shelf selectedShelf) {
        this.selectedShelf = selectedShelf;
    }
    
    public String addShelf(){
    	shelfService.addEntity(shelfService.getShelfRepository(), newShelf);
    	return null;
    }
    
    public String editShelf(){
    	return null;
    }
    
    public String deleteShelf(){
    	shelfService.removeEntity(shelfService.getShelfRepository(), selectedShelf);
    	return null;
    }
}
