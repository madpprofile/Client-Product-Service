package br.cefet.aps.cfs.view.product;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.view.Command;

public class UpdateProductCommand implements Command {

	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 6){
			System.out.println("Invalid parameters");
			usage();
			return;
		}
		try{
			ControlFacade cf = ControlFacade.getInstance();
			Long id = Long.parseLong(parameters[1]);
			Long newId = Long.parseLong(parameters[2]); 
			String newName = parameters[3]; 
			Long newQuantity = Long.parseLong(parameters[4]);
			int type = Integer.parseInt(parameters[5]);
			cf.updateProduct(id, newId, newName, newQuantity, type);
		} catch(NumberFormatException e){
			System.out.println("Invalid id(s), quantity or type");
		} catch(NullPointerException e){
			System.out.println("Product type " + parameters[5] + "doesn't exists");
		}
		
	}
	
	public void usage(){
		System.out.println(
				"Usage: updateProduct id newId newName newQuantity \n" +
				"Description: updates a product in database" +
				"Product types:\n" +
				"0 - general\n"
			);
	}
}
