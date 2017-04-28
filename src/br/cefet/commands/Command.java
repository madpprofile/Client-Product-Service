package br.cefet.commands;

import java.util.List;

public interface Command {
	public void execute(List<Object> parameters);
}
