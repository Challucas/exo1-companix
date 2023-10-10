package companix;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Salarie {
	
	private String code;
	private String nom;
	private String prenom;
	private Date dateEmbauche;

	public Salarie(String code, String nom, String prenom, Date dateEmbauche) {
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
	}
	
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dateEmbaucheStr = sdf.format(dateEmbauche);
		String toString = "Code : " + code + " | Nom : "+nom+" | Prenom : "+prenom+" | date d'embauche : "+dateEmbaucheStr+" | ";
		return toString;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}



}
