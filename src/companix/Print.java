package companix;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Print {

	public static void printMenu() {
		System.out.println(
				"1- Ajouter un concepteur \r\n"
				+ "2- Supprimer un concepteur \r\n"
				+ "3- Liste des concepteurs existants \r\n"
				+ "4- Ajouter un analyste \r\n"
				+ "5- Supprimer un analyste \r\n"
				+ "6- Liste des analystes \r\n"
				+ "7- Liste de tous les salaries \r\n"
				+ "8- Quitter \r\n"
				+ "      Faites votre choix (1,2,3,4,5,6,7,8) : "
			);

	}
	
	static void back() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cliquer sur une touche pour revenir en arrière : ");
		String retour = sc.next();
		
	}
	
	//TODO Concepteur
	
	static Map printCreateConcepteur() {
        Scanner sc = new Scanner(System.in);
        int anneeDeveloppement = 0;
        Date localDateEmbauche = null;
        boolean formatDate = false;
        boolean formatAnneeDev = false;
        String dateEmbauche = "";
        String anneeDeveloppementStr = "";
        
        System.out.println("Saisir le code: ");
        String code = sc.next();

        System.out.println("Saisir le nom: ");
        String nom = sc.next();

        System.out.println("Saisir le prénom: ");
        String prenom = sc.next();
        System.out.println("Saisir la date (yyyy-mm-dd): ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        while(!formatDate) {
            dateEmbauche = sc.next();
        	try {
        		localDateEmbauche = dateFormat.parse(dateEmbauche);
        		formatDate = true;
        	} catch(Exception e) {
        		System.out.println("Le format de la date n'est pas correcte");        		
        	}
        }
        
        System.out.println("Saisir le nombre d'année de développement: ");
        while(!formatAnneeDev) {
        	anneeDeveloppementStr = sc.next(); 
        	try {
        		anneeDeveloppement = Integer.parseInt(anneeDeveloppementStr);
        		formatAnneeDev = true;
        	} catch (Exception e) {
        		System.out.println("Le nombre d'année de développement doit etre un entier, merci de recréer un concepteur");
        	}        	
        }

        Map mapInfoConcepteur = new HashMap();
        
        mapInfoConcepteur.put("code" ,code);
        mapInfoConcepteur.put("nom",nom);
        mapInfoConcepteur.put("prenom" ,prenom);
        mapInfoConcepteur.put("dateEmbauche",localDateEmbauche);
        mapInfoConcepteur.put("anneeDeveloppement",anneeDeveloppement);
        
        return mapInfoConcepteur;
	}
	
	
	static void printListConcepteur(ArrayList<Salarie> allSalarie) {
		for(Salarie concepteur : allSalarie) {
			if(concepteur instanceof Concepteur) {
				System.out.println(concepteur.toString());				
			}
		}
		
	}
	
	static String printSelectDeleteConcepteur(ArrayList<Salarie> allSalarie) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisisez le numéro du concepteur à supprimer");
		String numSupprConcepteur = sc.next();
		return numSupprConcepteur;
	}
	
	//TODO Analyste
	
	static Map printCreateAnalyste() {
        Scanner sc = new Scanner(System.in);
        int nbrDeplacementClient = 0;
        Date localDateEmbauche = null;
        boolean formatDate = false;
        boolean formatAnneeEmbauche = false;
        String dateEmbauche = "";
        String nbrDeplaClientStr = "";

        System.out.println("Saisir le code: ");
        String code = sc.next();

        System.out.println("Saisir le nom: ");
        String nom = sc.next();

        System.out.println("Saisir le prénom: ");
        String prenom = sc.next();

        System.out.println("Saisir la date (yyyy-mm-dd): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        while(!formatDate) {
        	dateEmbauche = sc.next();
        	try {
        		localDateEmbauche = dateFormat.parse(dateEmbauche);
        		formatDate = true;
        	} catch(Exception e) {
        		System.out.println("Le format de la date n'est pas correcte");        		
        	}
        }
        
        System.out.println("Saisir le nombre de déplacement client : ");
        while(!formatAnneeEmbauche) {
        	nbrDeplaClientStr = sc.next(); 
        	try {
        		nbrDeplacementClient = Integer.parseInt(nbrDeplaClientStr);
        		formatAnneeEmbauche = true;
        	} catch (Exception e) {
        		System.out.println("Le nombre d'année de déplacement client doit etre un entier, merci de recréer un concepteur");
        	}        	
        }

        Map mapInfoAnalyste = new HashMap();
        
        mapInfoAnalyste.put("code" ,code);
        mapInfoAnalyste.put("nom",nom);
        mapInfoAnalyste.put("prenom" ,prenom);
        mapInfoAnalyste.put("dateEmbauche",localDateEmbauche);
        mapInfoAnalyste.put("nbrDeplacementClient",nbrDeplacementClient);
        
        return mapInfoAnalyste;
	}
		static void printListAnalyste(ArrayList<Salarie> allSalarie) {
			for(Salarie analyste : allSalarie) {
				if(analyste instanceof Analyste) {
					System.out.println(analyste.toString());					
				}
			}
			
		}

		static String printSelectDeleteAnalyste(ArrayList<Salarie> allSalarie) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Saisisez le numéro du concepteur à supprimer");
			String numSupprAnalyste = sc.next();
			return numSupprAnalyste;
		}
		
		static void printAllSalarie(ArrayList<Salarie> allSalarie) {
			for(Salarie salarie : allSalarie)
			{
				System.out.print(salarie);
				if(salarie instanceof Concepteur) {
					System.out.println(" | Fonction : Concepteur");
				}
				else if(salarie instanceof Salarie) {
					System.out.println(" | Fonction : Analyste");
				}
			}
		}

}
