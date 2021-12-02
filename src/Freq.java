import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Freq implements Command {

	@Override
	public String name() {
		return "freq";
	}

	@Override
	public boolean run(Scanner scan) {
		System.out.println("Execution de freq");
		System.out.println("Saisir le chemin entier de votre fichier a tester : ");
		String path = scan.nextLine();
		Path filePath = Paths.get(path);
		 
        try
        {
            String content = Files.readString(filePath);
            String cantentNoPonctu = content.replaceAll("[^a-zA-Zéèçàùêîûôâ]"," ");
            String contentMaj = cantentNoPonctu.toUpperCase();
            String[] mots = contentMaj.split(" ");
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
            System.out.println(listeMots.get(index2).toLowerCase() + " " + listeMots.get(index1).toLowerCase()+ " "  +listeMots.get(index0).toLowerCase() );
        } 
        catch (IOException e) 
        {
        	System.out.println("Unreadable file: Freq " + e);
        }finally {
        	return false;
		}
		
	}

}
