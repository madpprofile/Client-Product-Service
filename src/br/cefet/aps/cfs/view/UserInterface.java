package br.cefet.aps.cfs.view;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println("Insert a command:");
			String[] parameters = sc.nextLine().split(" ");
			if(parameters[0].equals("exit"))
				System.exit(0);
			if(!Invoker.executeCommand(parameters[0], parameters))
				UserInterface.usage();
		}
		sc.close();
	}
	
	public static void usage(){
		System.out.println(
				"Usage:\n\n" +
				"[command] [parameters]\n\n" +
				"[command] options:\n" +
				"\taddClient, updateClient, deleteClient, listClients\n" +
				"\taddProduct, updateProduct, deleteProduct, listProducts\n"+
				"\texit"
			);
	}

}
