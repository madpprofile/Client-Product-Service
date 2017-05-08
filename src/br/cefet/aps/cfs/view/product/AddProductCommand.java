package br.cefet.aps.cfs.view.product;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class AddProductCommand implements Command{

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
			String name = parameters[2];
			Long quantity = Long.parseLong(parameters[3]);
			int type = Integer.parseInt(parameters[4]);
			cf.insertProduct(id, name, quantity, type);
		} catch(NumberFormatException e){
			System.out.println("Invalid id, quantity or type");
		} catch(NullPointerException e){
			System.out.println("Product type " + parameters[3] + "doesn't exists");
		}
	}
	
	public void usage(){
		System.out.println(
				"Usage: addProduct id name quantity type\n" +
				"Description: adds a new product to database" +
				"Product types:\n" +
				"0 - general\n"
			);
	}
}
