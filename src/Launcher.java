import java.util.Scanner;

public class Launcher {
	
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	
	public static void main(String args[]){  
		System.out.println("Bienvenu!");  
		String saisie = scanner.nextLine();
		while (!saisie.equals("quit")) {
			if (saisie.equals("fibo")) {
				int fibo = fibonacci();
				System.out.println("Le resultat est : " + fibo);
			}else {
				System.out.println("Unknown command");
			}
			saisie = scanner.nextLine();
			
		}
	} 
	
	public static int fibonacci() {
		System.out.println("Saisir votre n ");
		int saisie = scanner2.nextInt();
		System.out.println("Calcul de fibo pour n = " + saisie);
		int i = 0;
		int fibo0 = 0;
		int fibo1 = 1;
		if (saisie == 0) {
			return fibo0;
		}
		if (saisie == 1) {
			return fibo1;
		}
		while (i < saisie) {
			int fibo = fibo1 + fibo0;
			fibo0 = fibo1;
			fibo1 = fibo;
			i++;
		}
		return fibo0;
	}

}
