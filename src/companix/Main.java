package companix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Salarie> listSalarieConcepteur = new ArrayList<Salarie>();
		ArrayList<Salarie> listSalarieAnalyste = new ArrayList<Salarie>();
		ArrayList<Salarie> allSalarie = new ArrayList<Salarie>();
		
		choiceMenu(allSalarie);
	}

	private static void choiceMenu(ArrayList<Salarie> allSalarie)
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		Print.printMenu();
		boolean correctChoice = false;
		while(correctChoice == false){
			try {
				choice = sc.nextInt();
			} catch(Exception e) {
				System.out.println("Le choix menu doit etre un entier");
			}
			switch(choice) {
			case 1 :
				createConcepteur(allSalarie);
				break;
			case 2 :
				deleteConcepteur(allSalarie);
				break;
			case 3 :
				listConcepteur(allSalarie);
				break;
			case 4 :
				createAnalyste(allSalarie);
				break;
			case 5 :
				deleteAnalyste(allSalarie);
				break;
			case 6 :
				listAnalyste(allSalarie);
				break;
			case 7 :
				listSalarie(allSalarie);
				break;
			case 8 :
				correctChoice = true;
				break;
			default : 
				System.out.println("Veuillez-choisir entre les propositions suivantes : 1,2,3,4,5,6,7");
			}
			choiceMenu(allSalarie);
			
			
		}
	}
	
	//TODO Concepteur
	private static ArrayList<Salarie> createConcepteur(ArrayList<Salarie> allSalarie) {
	    Scanner sc = new Scanner(System.in);
	    Map mapInfoConcepteur = Print.printCreateConcepteur();

	    String code = (String) mapInfoConcepteur.get("code");

	    boolean codeExists = false;
	    for (Salarie salarie : allSalarie) {
	    	if (salarie.getCode().equals(code)) {
	            codeExists = true;
	            break;
	        }
	    }

	    if (!codeExists) {
	        String nom = (String) mapInfoConcepteur.get("nom");
	        String prenom = (String) mapInfoConcepteur.get("prenom");
	        Date dateEmbauche = (Date) mapInfoConcepteur.get("dateEmbauche");
	        int anneeDeveloppement = (int) mapInfoConcepteur.get("anneeDeveloppement");
	        Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbauche, anneeDeveloppement);
	        allSalarie.add(concepteur);
	    } else {
	        System.out.println("Le code existe déjà dans la liste.");
	        Print.back();
	    }

	    return allSalarie;
	}

		
	
	
	private static void listConcepteur(ArrayList<Salarie> allSalarie) {
		
		Print.printListConcepteur(allSalarie);
		Print.back();
		
	}
	
	private static void deleteConcepteur(ArrayList<Salarie> allSalarie) {
		String codeRemove = Print.printSelectDeleteConcepteur(allSalarie);
		boolean codeExists = false;
	    for (Salarie salarie : allSalarie) {
	    	if (salarie instanceof Concepteur && ((Concepteur) salarie).getCode().equals(codeRemove)) {
	            codeExists = true;
	            break;
	        }
	    }
	    if (codeExists) {
			for(int i = 0; i < allSalarie.size(); i++) {
				if(codeRemove.equals(allSalarie.get(i).getCode())) {
					allSalarie.remove(allSalarie.get(i));
				}
			}
	    }
	    else {
	    	System.out.println("Le code n'existe pas dans la liste ou il ne fait pas parti des concepteurs.");
	    }
		
		Print.back();
	}
	
//TODO Analyste	
	private static ArrayList<Salarie> createAnalyste(ArrayList<Salarie> allSalarie) {
		
		Scanner sc = new Scanner(System.in);
		Map mapInfoAnalyste = Print.printCreateAnalyste();
	
		String code = (String) mapInfoAnalyste.get("code");
		
		 boolean codeExists = false;
		    for (Salarie salarie : allSalarie) {
		    	if (salarie.getCode().equals(code)) {
		            codeExists = true;
		            break;
		        }
		    }
		if (!codeExists) {
			String nom = (String) mapInfoAnalyste.get("nom");
			String prenom = (String) mapInfoAnalyste.get("prenom");
			Date dateEmbauche = (Date) mapInfoAnalyste.get("dateEmbauche");
			int nbrDeplacementClient = (int) mapInfoAnalyste.get("nbrDeplacementClient");
			Analyste analyste = new Analyste(code, nom, prenom, dateEmbauche, nbrDeplacementClient);
			allSalarie.add(analyste);
			
		}
		else {
	        System.out.println("Le code existe déjà dans la liste.");
	    }
		return allSalarie;
		
	}
	
	
	private static void listAnalyste(ArrayList<Salarie> allSalarie) {
		
		Print.printListAnalyste(allSalarie);
		Print.back();
		
	}
	
	private static void deleteAnalyste(ArrayList<Salarie> allSalarie) {
		String codeRemove = Print.printSelectDeleteAnalyste(allSalarie);
		boolean codeExists = false;
	    for (Salarie salarie : allSalarie) {
	    	if (salarie instanceof Analyste && ((Analyste) salarie).getCode().equals(codeRemove)) {

	            codeExists = true;
	            break;
	        }
	    }
	    if (codeExists) {
			for(int i = 0; i < allSalarie.size(); i++) {
				if(codeRemove.equals(allSalarie.get(i).getCode())) {
					allSalarie.remove(allSalarie.get(i));
				}
			}
	    }
	    else {
	    	System.out.println("Le code n'existe pas dans la liste ou il ne fait pas parti des analystes.");
	    }
		
		Print.back();
	}
	
	
	//TODO Liste Salaries
	
	private static void listSalarie(ArrayList<Salarie> allSalarie) {

		
		Collections.sort(allSalarie, new Comparator<Salarie>() {

            public int compare(Salarie s1, Salarie s2) {
                return s1.getCode().compareTo(s2.getCode());
            }
        });
		
		Print.printAllSalarie(allSalarie);
		Print.back();
	}
	

}
