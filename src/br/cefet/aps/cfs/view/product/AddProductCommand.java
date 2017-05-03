package br.cefet.aps.cfs.view.product;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class AddProductCommand implements Command{

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 4){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			Long id = Long.parseLong(parameters[1]);
			String name = parameters[2];
			Long quantity = Long.parseLong(parameters[3]);
			ControlFacade.insertProduct(id, name, quantity);
		} catch(NumberFormatException e){
			System.out.println("Invalid id or quantity");
		}
	}
	
	public void usage(){
		System.out.println(
				"Usage: addProduct id name quantity\n" +
				"Description: adds a new product to database"
			);
	}
}
