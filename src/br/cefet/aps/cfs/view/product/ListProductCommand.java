package br.cefet.aps.cfs.view.product;

import java.util.List;

import br.cefet.aps.cfs.control.ControlFacade;
import br.cefet.aps.cfs.model.Product;
import br.cefet.aps.cfs.view.Command;

public class ListProductCommand implements Command{
	
	@Override
	public void execute(String[] parameters) {
		if(parameters.length != 1){
			System.out.println("Command listProducts has no parameters");
		}
		List<Product> clients = ControlFacade.listProducts();
		clients.forEach(System.out::println);
	}

}
