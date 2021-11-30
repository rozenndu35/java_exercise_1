import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Predict implements Command {

	@Override
	public String name() {
		return "predict";
	}

	@SuppressWarnings("finally")
	@Override
	public boolean run(Scanner scan) {
		System.out.println("Execution de predict");
		System.out.println("Saisir le chemin entier de votre fichier a tester : ");
		String path = scan.nextLine();
		Path filePath = Paths.get(path);
		 
        try
        {
        	//Initialisation
            String content = Files.readString(filePath);
            String contentMaj = content.toUpperCase();
            String cantentNoPonctu = contentMaj.replaceAll("[^A-Z]"," ");
            String[] mots = cantentNoPonctu.split(" ");
            List<Mot> listeMots = new ArrayList<Mot>();
            int index = 0;
            while (index < mots.length){
            	if(!mots[index].isEmpty()) {
            		int j = index+1;
            		while (j <  mots.length && mots[j].isEmpty() ) {
            			j ++;
            		}
            		String motActuel = mots[index];
            		Mot motPresent = listeMots.stream()
          				  .filter(mot -> motActuel.equals(mot.getNom()))
          				  .findAny()
          				  .orElse(null);
            		if (motPresent == null) {
            			Mot newMot = new  Mot(mots[index]);
            			if(j < mots.length) {
                			newMot.ajouterMotSuivant(mots[j]);
            			}
            			listeMots.add(newMot);
            		}else {
            			if(j < mots.length) {
            				motPresent.ajouterMotSuivant(mots[j]);
            			}
            		}
            		index=j;
            	}
            }
            
            //Création de la phrase
            System.out.println("Saisir votre premier mot : ");
            String motClient = scan.nextLine();
            String clienMaj = motClient.toUpperCase();
            
            Mot motPresent = listeMots.stream()
    				  .filter(mot -> clienMaj.equals(mot.getNom()))
    				  .findAny()
    				  .orElse(null);
            
            if (motPresent == null) {
            	throw new MotNonTrouver("Le mot ne fait pas partie du texte d'initialisation!");
            }else {
            	int phraseLong = 1;
            	String phrase = motClient;
            	Mot oldMot = motPresent;
            	boolean peuContinue = true;
            	while (phraseLong < 20 && peuContinue && oldMot != null) {
            		String newMot = oldMot.nextMotPredict();
            		if( newMot != null) {
            			phrase += " "+newMot.toLowerCase();
            			phraseLong ++;
            			oldMot = listeMots.stream()
	      				  .filter(mot -> newMot.equals(mot.getNom()))
	      				  .findAny()
	      				  .orElse(null);
            					
            		}
            		
            	}
            	System.out.println("La phrase créér : " + phrase);
            	
            }
            
            
        } 
        catch (Exception e) 
        {
        	System.out.println("Unreadable file: " + e.getClass().getSimpleName() + e.getMessage());
        }finally {
        	return false;
		}
	}

}
