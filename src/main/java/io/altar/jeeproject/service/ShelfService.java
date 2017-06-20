package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.repository.ShelfRepository;

@ManagedBean(name = "shelfService")
@ApplicationScoped
public class ShelfService {
	private ShelfRepository shelfList = new ShelfRepository();

	public List<Shelf> createShelves() {
		List<Shelf> list = new ArrayList<Shelf>();
		shelfList.addToList(new Shelf(1, 5, 0, 2.0));
		shelfList.addToList(new Shelf(2, 7, 0, 3.0));
		list = new ArrayList<Shelf>((Collection<Shelf>) shelfList.values());
		return list;
	}
}
