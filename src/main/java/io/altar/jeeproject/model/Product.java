package io.altar.jeeproject.model;

import java.util.ArrayList;

import io.altar.jeeproject.repository.ProductRepository;

public class Product extends Entity{
	private ArrayList<Integer> shelfIdLocation;
	private String name;
	private Integer discount;
	private Integer tax;
	private Double salePrice;	
	private ProductRepository productRepository = new ProductRepository();
	
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
	
	public Product(ArrayList<Integer> shelfIdLocation, String name, Integer discount, Integer tax, Double salePrice){
		this.shelfIdLocation = shelfIdLocation;
		this.name = name;
		this.discount = discount;
		this.tax = tax;
		this.salePrice = salePrice;
		productRepository.addToList(this);
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
