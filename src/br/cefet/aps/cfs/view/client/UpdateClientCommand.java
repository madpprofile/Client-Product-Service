package br.cefet.aps.cfs.view.client;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class UpdateClientCommand implements Command{

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 4){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			ControlFacade.updateClient(Long.parseLong(parameters[1]),
					Long.parseLong(parameters[2]), parameters[3]);
		} catch(NumberFormatException e){
			System.out.println("Invalid id(s)");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: updateClient id newId newName \n" +
				"Description: updates a client in database"
			);
	}

}
