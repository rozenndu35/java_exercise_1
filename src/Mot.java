import java.util.ArrayList;

public class Mot {
	private ArrayList<String> listeMots = new ArrayList<String>();
    private ArrayList<Integer> listeNombre = new ArrayList<Integer>();
    private String nom;
    
    public Mot(String p_nom) {
    	this.nom = p_nom;
    }
    public void ajouterMotSuivant( String p_motSuivant) {
    	if(!p_motSuivant.isEmpty()) {
    		if(!listeMots.contains(p_motSuivant)) {
    			listeMots.add(p_motSuivant);
    			listeNombre.add(1);
    		}else {
    			listeNombre.set(listeMots.indexOf(p_motSuivant), listeNombre.get(listeMots.indexOf(p_motSuivant)) + 1);
    		}
    	}
    }
    
    public String nextMotPredict() {
        int index = 0;
        int i = 0;
        if(listeNombre.isEmpty()) {
        	return null;
        }
        for(Integer elem: listeNombre){
        	if(listeNombre.get(index)  <= elem) {
        		index = i;
        	}
        	i++;
        }
        return listeMots.get(index);
    }
    
    public String getNom() {
    	return this.nom;
    }
}
