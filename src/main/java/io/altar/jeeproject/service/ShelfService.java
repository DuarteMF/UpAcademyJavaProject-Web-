package io.altar.jeeproject.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.repository.ShelfRepository;

@Named("shelfService")
@ApplicationScoped
public class ShelfService extends EntityService<Shelf>{
	@Inject
	private ShelfRepository shelfList;
	
	public ShelfRepository getShelfRepository(){
		return shelfList;
	}

//	public List<Shelf> showShelves() {
//		List<Shelf> list = new ArrayList<Shelf>((Collection<Shelf>) shelfList.values());
//		return list;
//	}
//	
//	public void addShelf(){
//		shelfList.addToList(new Shelf(1 ,2,null,5.0));
//	}
}
