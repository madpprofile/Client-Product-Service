package br.cefet.commands;

import java.util.List;

public class ListClientCommand implements Command{

	@Override
	public void execute(List<Object> parameters) {
		Database.list();
	}
	

}
