package br.cefet.aps.cfs.view;

import java.util.HashMap;
import java.util.Map;

import br.cefet.aps.cfs.view.client.AddClientCommand;
import br.cefet.aps.cfs.view.client.DeleteClientCommand;
import br.cefet.aps.cfs.view.client.ListClientCommand;
import br.cefet.aps.cfs.view.client.UpdateClientCommand;
import br.cefet.aps.cfs.view.product.AddProductCommand;
import br.cefet.aps.cfs.view.product.DeleteProductCommand;
import br.cefet.aps.cfs.view.product.ListProductCommand;
import br.cefet.aps.cfs.view.product.UpdateProductCommand;

public class Invoker {
	public static Map<String, Command> commands;
	
	static{
		commands = new HashMap<String, Command>();

		commands.put("addClient", new AddClientCommand());
		commands.put("updateClient", new UpdateClientCommand());
		commands.put("deleteClient", new DeleteClientCommand());
		commands.put("listClients", new ListClientCommand());
		
		commands.put("addProduct", new AddProductCommand());
		commands.put("updateProduct", new UpdateProductCommand());
		commands.put("deleteProduct", new DeleteProductCommand());
		commands.put("listProducts", new ListProductCommand());
		
	}
	
	public static boolean executeCommand(String action, String[] parameters){
		if(!commands.containsKey(action)){
			System.out.println("Command " + action + " not found");
			return false;
		}
		commands.get(action).execute(parameters);
		return true;
	}

}
