import java.util.Scanner;

public class Fibo implements Command {

	@Override
	public String name() {
		return "fibo";
	}

	@Override
	public boolean run(Scanner scan) {
		System.out.println("Execution de fibo");
		System.out.println("Saisir votre n ");
		int saisie = scan.nextInt();
		System.out.println("Calcul de fibo pour n = " + saisie);
		int i = 0;
		int fibo0 = 0;
		int fibo1 = 1;
		int resultat = 0;
		if (saisie == 0) {
			resultat = fibo0;
		}
		if (saisie == 1) {
			resultat =  fibo1;
		}else {
			while (i < saisie) {
				int fibo = fibo1 + fibo0;
				fibo0 = fibo1;
				fibo1 = fibo;
				i++;
			}
			resultat = fibo0;
		}
		
		System.out.println("Le resultat est : " + resultat);
		scan.nextLine();
		return false;
	}

}
