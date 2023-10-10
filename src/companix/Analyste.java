package companix;

import java.util.Date;

public class Analyste extends Salarie{

	int nbrDeplacementClient;
	public Analyste(String code, String nom, String prenom, Date dateEmbauche, int nbrDeplacementClient) {
		super(code, nom, prenom, dateEmbauche);
		this.nbrDeplacementClient = nbrDeplacementClient;
	}
	public int getNbrDeplacementClient() {
		return nbrDeplacementClient;
	}
	public void setNbrDeplacementClient(int nbrDeplacementClient) {
		this.nbrDeplacementClient = nbrDeplacementClient;
	}
	@Override
	public String toString() {
		return super.toString() + "Nombre de déplacement : " + nbrDeplacementClient;
	}
	
	

}
