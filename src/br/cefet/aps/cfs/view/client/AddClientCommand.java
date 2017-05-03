package br.cefet.aps.cfs.view.client;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class AddClientCommand implements Command {

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 3){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			Long id = Long.parseLong(parameters[1]);
			String name = parameters[2];
			ControlFacade.insertClient(id, name);
		} catch(NumberFormatException e){
			System.out.println("Invalid id");
		}
	}
	
	public void usage(){
		System.out.println(
				"Usage: addClient id name\n" +
				"Description: adds a new client to database"
			);
	}
	

}
