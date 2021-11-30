import java.util.Scanner;

public interface Command {
	
	/*
	 * renvoi le nom de la commande a saisir par l'utilisateur
	 * @return le nom de la commande
	 */
	public String name();
	/*
	 * renvoi si la commande arrete le programme et execute la commande
	 * @return false si il continue true sinon
	 */
	public boolean run(Scanner scan);
}
