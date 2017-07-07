package io.altar.jeeproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SHELVES")
public class Shelf extends EntityModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Localização")
	private Integer location = 0;
	@Column(name="Capacidade")
	private Integer capacity = 0;
	@Column(name="Produto")
	private String productId = "0";
	@Column(name="Preço_de_Aluguer")
	private Double locationRentalPrice = 0.0;
	
	public void setLocation(Integer location){
		this.location = location;
	}
	
	public void setCapacity(Integer capacity){
		this.capacity = capacity;
	}
	
	public void setLocationRentalPrice(Double locationRentalPrice){
		this.locationRentalPrice = locationRentalPrice;
	}
	
	public Integer getLocation(){
		return this.location;
	}
	
	public Integer getCapacity(){
		return this.capacity;
	}
	
	public Double getLocationRentalPrice(){
		return this.locationRentalPrice;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Shelf(){
//		ShelfRepository.getInstance().addToList(this);
	}
	
	@Override
	public String toString(){
		return String.format("| ID: %d | Localização: %d | Capacidade: %d | ID do Produto: %d | Preço de Aluguer: %.2f€|\n", getId(), location, capacity, productId, locationRentalPrice);
	}
}
