package br.cefet.aps.cfs.model;

public class ClientVIP extends Client {

	public ClientVIP(Long id, String name){
		super(id, name);
	}
	
	@Override
	public float getDiscount() {
		return 0.15F;
	}


}
