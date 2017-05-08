package br.cefet.aps.cfs.model;

public abstract class Client {
	private Long id;
	private String name;
	
	protected Client(Long id, String name){
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getName();
	}
	
	public abstract float getDiscount();

}
