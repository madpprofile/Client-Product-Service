package br.cefet.aps.cfs.view.client;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class AddClientCommand implements Command {

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 4){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			ControlFacade cf = ControlFacade.getInstance();
			Long id = Long.parseLong(parameters[1]);
			String name = parameters[2];
			int type = Integer.parseInt(parameters[3]);
			cf.insertClient(id, name, type);
		} catch(NumberFormatException e){
			System.out.println("Invalid id or Client type");
		} catch(NullPointerException e){
			System.out.println("Client type " + parameters[3] + "doesn't exists");
		}
	}
	
	public void usage(){
		System.out.println(
				"Usage: addClient id name\n" +
				"Description: adds a new client to database\n" +
				"Client types:\n" +
				"0 - common\n" +
				"1 - VIP"
			);
	}
	

}
