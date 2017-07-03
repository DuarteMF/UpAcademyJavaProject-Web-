package io.altar.jeeproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product extends EntityModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Prateleiras", nullable = true)
	private String shelfIdLocation ="teste";
//	private ArrayList<Integer> shelfIdLocation = new ArrayList<>();
	private String name = "nome";
	@Column(name="Desconto")
	private Integer discount = 0;
	@Column(name="IVA")
	private Integer tax = 0;
	@Column(name="Preço")
	private Double salePrice = 0.0;
	
	public void setShelfIdLocation(String shelfIdLocation){
		this.shelfIdLocation = shelfIdLocation;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDiscount(Integer discount){
		this.discount = discount;
	}
	
	public void setTax(Integer tax){
		this.tax = tax;
	}
	
	public void setSalePrice(Double salePrice){
		this.salePrice = salePrice;
	}
	
	public String getShelfIdLocation(){
		return this.shelfIdLocation;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getDiscount(){
		return this.discount;
	}
	
	public Integer getTax(){
		return this.tax;
	}
	
	public Double getSalePrice(){
		return this.salePrice;
	}
	
	public Product(){
//		ProductRepository.getInstance().addToList(this);
	}
	
	@Override
	public String toString(){
		String shelfString = null;
		if(!(shelfIdLocation.isEmpty())){
			shelfString = shelfIdLocation.toString();
		}
		return String.format("| ID: %d | Nome: %s | Prateleiras: %s | Desconto: %d%% | IVA: %d%% | PVP: %.2f€ |\n", getId(), name, shelfString, discount, tax, salePrice);
	}
	
}
