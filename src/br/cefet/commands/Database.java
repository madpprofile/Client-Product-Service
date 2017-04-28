package br.cefet.commands;

import java.util.HashMap;
import java.util.Map;

public class Database {
	
	private static Map<Long, Client> clients;
	
	static{
		clients = new HashMap<Long, Client>();
	}

	public static void insert(Client cli) {
		clients.put(cli.getId(), cli);
	}
	
	public static void update(Client cli, Client novo_cli) {
		clients.remove(cli.getId(), cli);
		clients.put(novo_cli.getId(), novo_cli);
	}

	public static void delete(Client cli) {
		clients.remove(cli.getId(), cli);
	}

	public static void list(){
		for(int i=0; i<clients.size(); i++) {
			System.out.println(clients.get(new Long(i)));
		}
	}
}
