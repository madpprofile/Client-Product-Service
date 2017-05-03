package br.cefet.aps.cfs.view.product;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class UpdateProductCommand implements Command {

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 5){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			ControlFacade.updateProduct(Long.parseLong(parameters[1]),
					Long.parseLong(parameters[2]), parameters[3], 
					Long.parseLong(parameters[4]));
		} catch(NumberFormatException e){
			System.out.println("Invalid id(s) or quantity");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: updateProduct id newId newName newQuantity \n" +
				"Description: updates a product in database"
			);
	}
}
