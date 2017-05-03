package br.cefet.aps.cfs.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is an abstraction of a database.
 * @author Mateus
 *
 */
public class Database {
	//Singleton instance
	private static Database instance;
	private Map<Long, Client> clients;
	private Map<Long, Product> products;
	
	//Singleton
	private Database(){
		super();
		this.clients = new HashMap<Long, Client>();
		this.products = new HashMap<Long, Product>();
	}
	
	public static Database getInstance(){
		if(instance == null)
			instance = new Database();
		return instance;
	}
	
	//Client CRUD
	public void insertClient(Client c) {
		clients.put(c.getId(), c);
	}
	
	public void updateClient(Long id, Client nc) {
		clients.remove(id);
		clients.put(nc.getId(), nc);
	}

	public void deleteClient(Long id) {
		clients.remove(id);
	}

	public Map<Long, Client> getClients(){
		return this.clients;
	}
	
	//Products CRUD
	public void insertProduct(Product p) {
		products.put(p.getId(), p);
	}
	
	public void updateProduct(Long id, Product np) {
		products.remove(id);
		products.put(np.getId(), np);
	}

	public void deleteProduct(Long id) {
		products.remove(id);
	}

	public Map<Long, Product> getProducts(){
		return this.products;
	}
}
