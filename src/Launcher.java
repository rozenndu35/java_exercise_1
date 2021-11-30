import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
	
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static List<Command> listCommandes = new ArrayList<Command>();
	
	public static void main(String args[]){  
		System.out.println("Bienvenu!"); 
		
		listCommandes.add(new Fibo());
		listCommandes.add(new Freq());
		listCommandes.add(new Quit());
		
		boolean command = false;
		while (!command) {
			System.out.println("Saisir votre commande");
			String saisie = scanner.nextLine();
			command = verficationCommand(saisie);
			
		}
		System.out.println("Fin du programme!"); 
	} 
	
	private static boolean verficationCommand(String saisie) {
		Command choix = listCommandes.stream()
				  .filter(command -> saisie.equals(command.name()))
				  .findAny()
				  .orElse(null);
		if (choix ==  null) {
			System.out.println("Unknown command");
			return false;
		}else {
			return choix.run(scanner);
		}	 
		
	}
	


}
