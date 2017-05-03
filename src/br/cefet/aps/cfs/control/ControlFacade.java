package br.cefet.aps.cfs.control;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.model.Database;
import br.cefet.aps.cfs.model.Product;

public class ControlFacade {
	//client services
	public static void insertClient(Long id, String name){
		Database db = Database.getInstance();
		db.insertClient(new Client(id, name));
	}
	
	public static void updateClient(Long id, Long newId, String newName){
		Database db = Database.getInstance();
		db.updateClient(id, new Client(newId, newName));
	}
	
	public static void deleteClient(Long id){
		Database db = Database.getInstance();
		db.deleteClient(id);
	}
	
	public static List<Client> listClients(){
		Database db = Database.getInstance();
		Map<Long, Client> clients = db.getClients();
		List<Client> clientsList = clients.entrySet().stream()
				.map(id -> id.getValue()).collect(Collectors.toList());
		return clientsList;
	}
	
	//product services
	public static void insertProduct(Long id, String name, Long quantity){
		Database db = Database.getInstance();
		db.insertProduct(new Product(id, name, quantity));
	}
	
	public static void updateProduct(Long id, Long newId, String newName, Long newQuantity){
		Database db = Database.getInstance();
		db.updateProduct(id, new Product(newId, newName, newQuantity));
	}
	
	public static void deleteProduct(Long id){
		Database db = Database.getInstance();
		db.deleteProduct(id);
	}
	
	public static List<Product> listProducts(){
		Database db = Database.getInstance();
		Map<Long, Product> products = db.getProducts();
		List<Product> productsList = products.entrySet().stream()
				.map(id -> id.getValue()).collect(Collectors.toList());
		return productsList;
	}

}
