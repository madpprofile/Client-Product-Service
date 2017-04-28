package br.cefet.commands;

import java.util.List;

public class AddClientCommand implements Command {

	@Override
	public void execute(List<Object> parameters) {
		try{
			Client c = new Client((Long)(parameters.get(0)), (String)(parameters.get(1)));
			Database.insert(c);
		} catch(NullPointerException e){
			System.out.println("Missing parameters");
		} catch(ClassCastException e){
			System.out.println("Invalid parameters");
		}
	}
	

}
