package br.cefet.aps.cfs.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.model.Database;
import br.cefet.aps.cfs.model.Product;

public class ControlFacade {
	private static ControlFacade instance;
	private Map<Integer, ClientServices> clientServices;
	private Map<Integer, ProductServices> productServices;
	
	private ControlFacade(){
		instance.clientServices = loadClientServices();
		productServices = loadProductServices();
	}
	
	private Map<Integer, ClientServices> loadClientServices(){
		Map<Integer, ClientServices> clientServices = new HashMap<Integer, ClientServices>();
		
		//Add an instance here every time you create a new client type
		instance.clientServices.put(0, new ClientCommonServices());
		instance.clientServices.put(1, new ClientVIPServices());
		
		return clientServices;
	}
	
	private Map<Integer, ProductServices> loadProductServices(){
		Map<Integer, ProductServices> clientServices = new HashMap<Integer, ProductServices>();
		
		//Add an instance here every time you create a new product type
		instance.productServices.put(0, new ProductGeneralServices());
		
		return clientServices;
	}
	
	//Singleton
	public static ControlFacade getInstance(){
		if(instance == null)
			instance = new ControlFacade();
		return instance;
	}
	
	//client methods
	public void insertClient(Long id, String name, int type) 
			throws NullPointerException{
		ClientServices cs = clientServices.get(type);
		try{
			cs.insertClient(id, name);
		} catch(NullPointerException e){}
		
	}
	
	public void updateClient(Long id, Long newId, String newName, int type) 
			throws NullPointerException{
		ClientServices cs = clientServices.get(type);
		try{
			cs.updateClient(id, newId, newName);
		} catch(NullPointerException e){}
	}
	
	public void deleteClient(Long id){
		ClientServices cs = clientServices.get(0);
		cs.deleteClient(id);
	}
	
	public List<Client> listClients(){
		ClientServices cs = clientServices.get(0);
		List<Client> clientsList = cs.listClients();
		return clientsList;
	}
	
	//products methods
	public void insertProduct(Long id, String name, Long quantity, int type) 
			throws NullPointerException{
		ProductServices ps = productServices.get(type);
		try{
			ps.insertProduct(id, name, quantity);
		} catch(NullPointerException e){}
		
	}
	
	public void updateProduct(Long id, Long newId, String newName, Long newQuantity, int type) 
			throws NullPointerException{
		ProductServices ps = productServices.get(type);
		try{
			ps.updateProduct(id, newId, newName, newQuantity);
		} catch(NullPointerException e){}
	}
	
	public void deleteProduct(Long id){
		ProductServices ps = productServices.get(0);
		ps.deleteProduct(id);
	}
	
	public List<Product> listProducts(){
		ProductServices ps = productServices.get(0);
		List<Product> productsList = ps.listProducts();
		return productsList;
	}

}
