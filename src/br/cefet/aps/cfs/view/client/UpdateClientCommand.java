package br.cefet.aps.cfs.view.client;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class UpdateClientCommand implements Command{

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 5){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			ControlFacade cf = ControlFacade.getInstance();
			Long id = Long.parseLong(parameters[1]);
			Long newId = Long.parseLong(parameters[2]);
			String newName = parameters[3];
			int type = Integer.parseInt(parameters[4]);
			cf.updateClient(id, newId, newName, type);
		} catch(NumberFormatException e){
			System.out.println("Invalid id(s)");
		} catch(NullPointerException e){
			System.out.println("Client type " + parameters[4] + "doesn't exists");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: updateClient id newId newName newType\n" +
				"Description: updates a client in database" +
				"Client types:\n" +
				"0 - common\n" +
				"1 - VIP"
			);
	}

}
