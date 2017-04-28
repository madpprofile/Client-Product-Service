package br.cefet.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		String[] parameters = {"help"};
		List<Object> p = null;
		while(sc.hasNext()){
			i = 1;
			parameters = sc.nextLine().split(" ");
			p = new ArrayList<Object>();
			while(i < parameters.length){
				p.add(parameters[i]);
			}
			Invoker.executeCommand(parameters[0], p);
		}
		sc.close();
	}

}
