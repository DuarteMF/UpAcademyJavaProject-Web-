package io.altar.jeeproject.model;

public class Product extends Entity{
	private String shelfIdLocation ="teste";
//	private ArrayList<Integer> shelfIdLocation = new ArrayList<>();
	private String name = "nome";
	private Integer discount = 0;
	private Integer tax = 0;
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
