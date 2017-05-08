package br.cefet.aps.cfs.control;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.model.Database;

abstract class ClientServices {
	
	void insertClient(Long id, String name){
		Database db = Database.getInstance();
		db.insertClient(newClient(id, name));
	}
	
	void updateClient(Long id, Long newId, String newName){
		Database db = Database.getInstance();
		db.updateClient(id, newClient(newId, newName));
	}
	
	void deleteClient(Long id){
		Database db = Database.getInstance();
		db.deleteClient(id);
	}
	
	List<Client> listClients(){
		Database db = Database.getInstance();
		Map<Long, Client> clients = db.getClients();
		List<Client> clientsList = clients.entrySet().stream()
				.map(id -> id.getValue()).collect(Collectors.toList());
		return clientsList;
	}
	
	abstract Client newClient(Long id, String name);

}
