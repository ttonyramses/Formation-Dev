package gestionEleves;

import java.util.Scanner;
public class TestEleve {

	public static void main(String[] args){
		
		Scanner sc= new Scanner(System.in);
		boolean recommence=true;
		Eleve e=new Eleve("");
		redo:do{
			System.out.println("================================");
			System.out.println("Veuillez saisir une valeur : ");
			System.out.println("\t1-Pour initialisé un éleve");
			System.out.println("\t2-Pour ajouter un note");
			System.out.println("\t3-Afficher les information de l'eleve");
			System.out.println("\t>4-Quitter");
			System.out.print("\tchoix : ");
			
			if(!sc.hasNextInt()){
				sc.nextLine();
				continue redo;
			}
			int choix=sc.nextInt();
			sc.nextLine();
			
			
			switch(choix) {
				case 1 :
					System.out.println("================================");
					System.out.print("Veuillez saisir le nom de l'élève : ");
					String nom=sc.nextLine();
					e=new Eleve(nom);
					break;
				case 2 :
					boolean redo=false;
					do{
						
						System.out.println("================================");
						System.out.print("Veuillez saisir un numerique, une note : ");
						if(!sc.hasNextInt()){
							sc.nextLine();
							redo=true;
						}else{
							e.ajouterNote(sc.nextInt());
							sc.nextLine();
							redo=false;
						}
					}while(redo);
				break;
				
				case 3 :
					System.out.println(e);
					break;
					
				default :
				recommence=false;
				break;
			}
				
		}while(recommence);
		
		sc.close();
	}
}
