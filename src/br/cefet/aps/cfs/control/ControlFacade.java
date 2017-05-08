package br.cefet.aps.cfs.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.cefet.aps.cfs.model.Client;

public class ControlFacade {
	private ControlFacade controlFacade;
	private Map<Integer, ClientServices> clientServices;
	private Map<Integer, ProductServices> productServices;
	
	private ControlFacade(){
		controlFacade.clientServices = new HashMap<Integer, ClientServices>();
		controlFacade.clientServices.put(0, new ClientCommonServices());
		controlFacade.clientServices.put(1, new ClientVIPServices());
		
		productServices = new HashMap<Integer, ProductServices>();
	}
	
	//Singleton
	public ControlFacade getInstance(){
		if(controlFacade == null)
			controlFacade = new ControlFacade();
		return controlFacade;
	}
	
	//client methods
	public void insertClient(Long id, String name, int type) 
			throws NullPointerException{
		ClientServices cf = clientServices.get(type);
		try{
			cf.insertClient(id, name);
		} catch(NullPointerException e){}
		
	}
	
	public void updateClient(Long id, Long newId, String newName, int type) 
			throws NullPointerException{
		ClientServices cf = clientServices.get(type);
		try{
			cf.updateClient(id, newId, newName);
		} catch(NullPointerException e){}
	}
	
	public void deleteClient(Long id){
		ClientServices cf = clientServices.get(0);
		cf.deleteClient(id);
	}
	
	public List<Client> listClients(){
		ClientServices cf = clientServices.get(0);
		List<Client> clientsList = cf.listClients();
		return clientsList;
	}
	

}
