package br.cefet.aps.cfs.view.client;

import java.util.List;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.view.Command;

public class ListClientCommand implements Command{

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 1){
			System.out.println("Command listClients has no parameters");
		}
		ControlFacade cf = ControlFacade.getInstance();
		List<Client> clients = cf.listClients();
		clients.forEach(System.out::println);
	}
	

}
