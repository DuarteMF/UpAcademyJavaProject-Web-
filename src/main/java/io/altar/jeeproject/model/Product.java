package io.altar.jeeproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	private ArrayList<Integer> shelfIdLocation = new ArrayList<>();
	private String name = "name";
	private Integer discount = 0;
	private Integer tax = 0;
	private Double salePrice = 0.0;
	
	public void setShelfIdLocation(ArrayList<Integer> shelfIdLocation){
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
	
	public ArrayList<Integer> getShelfIdLocation(){
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
