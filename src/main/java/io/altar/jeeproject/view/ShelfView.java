package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ShelfService;

@ManagedBean(name="ShelfView")
@RequestScoped
public class ShelfView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Shelf> shelves;
	private Shelf selectedShelf;
	
	@Inject ShelfService shelfService;
 
    @PostConstruct
    public void init() {
    	shelves = shelfService.showShelves();
    			
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
    	Shelf shelf = new Shelf(1 ,2,null,5.0);
    	shelves.add(shelf);
    	return null;
    }
    
    public String editShelf(){
    	shelfService.addShelf();
    	return null;
    }
    
    public String deleteShelf(){
    	shelfService.addShelf();
    	return null;
    }
}
