import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
	
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);
	
	public static void main(String args[]){  
		System.out.println("Bienvenu!");  
		String saisie = scanner.nextLine();
		while (!saisie.equals("quit")) {
			if (saisie.equals("fibo")) {
				int fibo = fibonacci();
				System.out.println("Le resultat est : " + fibo);
			}else if (saisie.equals("freq")){
				freq();
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
		scanner2.nextLine();
		return fibo0;
		
	}

	public static void freq() {
		System.out.println("Saiir le chemin entier de votre fichier a tester : ");
		String path = scanner2.nextLine();
		Path filePath = Paths.get(path);
		 
        try
        {
            String content = Files.readString(filePath);
            String contentMaj = content.toUpperCase();
            String cantentNoPonctu = contentMaj.replaceAll("[^A-Z]"," ");
            String[] mots = cantentNoPonctu.split(" ");
            ArrayList<String> listeMots = new ArrayList<String>();
            ArrayList<Integer> listeNombre = new ArrayList<Integer>();
            for(String mot : mots) {
            	if(!mot.isEmpty()) {
            		if(!listeMots.contains(mot)) {
            			listeMots.add(mot);
            			listeNombre.add(1);
            		}else {
            			listeNombre.set(listeMots.indexOf(mot), listeNombre.get(listeMots.indexOf(mot)) + 1);
            		}
            	}
            }
            
         // Affichage à l'aide d'une boucle forEach
            for(String elem: listeMots)
            {
            	 System.out.println (elem);
            }
         // Affichage à l'aide d'une boucle forEach
            int index0 = 0;
            int index1 = 0;
            int index2 = 0;
            int i = 0;
            for(Integer elem: listeNombre){
            	if(listeNombre.get(index2)  <= elem) {
            		index0 = index1;
            		index1 = index2;
            		index2 = i;
            	}else if(listeNombre.get(index1)  <= elem) {
            		index0 = index1;
            		index1 = i;
            	}else if(listeNombre.get(index0)  <= elem) {
            		index0 = i;
            	}
            	i++;
            }
            System.out.println("Les 3 mots les plus souvent sont : " + listeMots.get(index0) +" "+ listeNombre.get(index0)+ "* " + listeMots.get(index1)+" "+ listeNombre.get(index1)+ "* "  +listeMots.get(index2) +" "+ listeNombre.get(index2)+ "*" );
        } 
        catch (IOException e) 
        {
        	System.out.println("Unreadable file: Launcher " + e);
        }finally {
			scanner2.nextLine();
		}
	}
}
