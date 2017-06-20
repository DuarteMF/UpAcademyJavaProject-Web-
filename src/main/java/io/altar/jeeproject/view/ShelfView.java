package io.altar.jeeproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.service.ShelfService;

@ManagedBean(name="ShelfView")
@ViewScoped
public class ShelfView implements Serializable{
	
	private List<Shelf> shelves;
	
	@ManagedProperty(value="#{shelfService}")
    private ShelfService shelfService;
 
    @PostConstruct
    public void init() {
    	shelves = shelfService.createShelves();
    			
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
}
