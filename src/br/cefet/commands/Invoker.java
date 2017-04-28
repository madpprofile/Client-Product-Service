package br.cefet.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoker {
	public static Map<String, Command> commands;
	
	static{
		commands = new HashMap<String, Command>();
		commands.put("add", new AddClientCommand());
	}
	
	public static void executeCommand(String action, List<Object> parameters){
		commands.get(action).execute(parameters);
	}

}
