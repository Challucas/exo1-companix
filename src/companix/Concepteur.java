package companix;

import java.util.Date;

public class Concepteur extends Salarie{
	
	int anneeDeveloppement;
	
	public Concepteur(String code, String nom, String prenom, Date dateEmbauche, int anneeDeveloppement) {
		super(code, nom, prenom, dateEmbauche);
		this.anneeDeveloppement = anneeDeveloppement;
	}
	
	
	public int getAnneeDeveloppement() {
		return anneeDeveloppement;
	}
	public void setAnneeDeveloppement(int anneeDeveloppement) {
		this.anneeDeveloppement = anneeDeveloppement;
	}

	@Override
	public String toString() {
		return super.toString() + "Nombre d'année de developpement : " + anneeDeveloppement;
	}
	
	



}
