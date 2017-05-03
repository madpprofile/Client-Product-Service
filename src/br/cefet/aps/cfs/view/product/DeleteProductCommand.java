package br.cefet.aps.cfs.view.product;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class DeleteProductCommand implements Command {

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 2){
			System.out.println("Invalid parameter");
			usage();
			return;
		}			
		try{
			ControlFacade.deleteProduct(Long.parseLong(parameters[1]));
		} catch(NumberFormatException e){
			System.out.println("Invalid id");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: deleteProduct id \n" +
				"Description: removes a product from database"
			);
	}
}
