package br.cefet.aps.cfs.model;

public class ProductGeneral extends Product {
	
	public ProductGeneral(Long id, String name, Long quantity){
		super(id, name, quantity);
	}

	@Override
	float getPrice() {
		return 10.99F;
	}

}
