package br.cefet.aps.cfs.model;

public class ClientCommon extends Client {

	public ClientCommon(Long id, String name){
		super(id, name);
	}
	
	@Override
	public float getDiscount() {
		return 0.05F;
	}


}
