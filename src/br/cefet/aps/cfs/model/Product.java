package br.cefet.aps.cfs.model;

public class Product {
	private Long id;
	private String name;
	private Long quantity;
	
	public Product(Long id, String name, Long quantity){
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return getId() + " " + getName() + " " + getQuantity();
	}
}
