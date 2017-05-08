package br.cefet.aps.cfs.view.client;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class DeleteClientCommand implements Command{

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 2){
			System.out.println("Invalid parameter");
			usage();
			return;
		}			
		try{
			ControlFacade cf = ControlFacade.getInstance();
			Long id = Long.parseLong(parameters[1]);
			cf.deleteClient(id);
		} catch(NumberFormatException e){
			System.out.println("Invalid id");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: deleteClient id \n" +
				"Description: removes a client from database"
			);
	}

}
