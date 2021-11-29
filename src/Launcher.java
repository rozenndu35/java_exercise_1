import java.util.Scanner;

public class Launcher {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]){  
		System.out.println("Bienvenu!");  
		String saisie = scanner.nextLine();
		while (!saisie.equals("quit")) {
			System.out.println("Unknown command");
			saisie = scanner.nextLine();
		}
	} 

}
