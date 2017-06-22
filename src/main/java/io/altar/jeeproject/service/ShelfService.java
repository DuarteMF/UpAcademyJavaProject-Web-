package io.altar.jeeproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import io.altar.jeeproject.model.Shelf;
import io.altar.jeeproject.repository.ShelfRepository;

@ManagedBean(name = "shelfService")
@ApplicationScoped
public class ShelfService {
	private ShelfRepository shelfList = ShelfRepository.getInstance();

	public List<Shelf> showShelves() {
		List<Shelf> list = new ArrayList<Shelf>((Collection<Shelf>) shelfList.values());
		return list;
	}
}
