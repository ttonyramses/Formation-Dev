package liste;

/* 
 * La classe liste modelise une liste d'entiers triee par ordre d'entiers croissants.
 * La classe utilisera necessairement une liste chainee dont les elements sont des 
 * instances de la classe Maillon
 * Modifier et completer le code ci-dessous.
 */
public class Liste {
	/*
	 * Si la liste est vide, l'attribut debut vaut null ;
	 * si la liste n'est pas vide, debut indique le premier maillon de la liste
	 */
	private Maillon debut;

	/*
	 * Si la liste est vide, l'attribut fin vaut null ;
	 * si la liste n'est pas vide, fin indique le dernier maillon de la liste 
	 */
	private Maillon fin;

	/*
	 * La methode ajouter ajoute l'entier n recu en parametre a la liste 
	 * en respectant l'ordre croissant.
	 * La donnee sera ajoutee meme si elle figure deja.
	 */
	public void ajouter(int n) {
		if(estVide()){
			debut=fin=new Maillon(n,debut,fin);
		}else{
			fin=new Maillon(n,debut,null);
			fin.getPrecedent().setSuivant(fin);
		}
	}

	/*
	 * La methode taille renvoie le nombre de maillons de la liste, c'est-a-dire le nombre de donnees
	 */
	public int taille() {
		int t=0;
		Maillon m=fin;
		while(m!=null){
			t++;
			m=m.getSuivant();
			
		}
		return t;
	}

	/*
	 * La methode existe renvoie true si le parametre valeur est contenu par un des maillons de la liste ;
	 * elle renvoie false sinon.
	 */
	public boolean existe(int valeur) {
		Maillon m=fin;
		while(m!=null && m.getDonnee()!=valeur){
			if(m!=null && m.getDonnee()==valeur) return true;
			m=m.getSuivant();
		}
		return false;
	}

	/*
	 * Si la liste est vide, la methode retirerPlusPetit envoie une exception de type VideException 
         * (voir le fichier VideException.java fourni) ;
	 * si la liste n'est pas vide, elle retire le premier maillon de la liste
	 * et renvoie la valeur contenue par le maillon supprime
	 */
	public int retirerPlusPetit() throws VideException {
		return 0;
	}

	/*
	 * Si la liste est vide, la methode plusGrand envoie une exception de type VideException ;
         * (voir le fichier VideException.java fourni) ;
	 * si la liste n'est pas vide, elle renvoie la plus grande valeur de la liste ;
	 * la methode ne supprime pas de maillon
	 */
	public int plusGrand() throws VideException {
		return 0;
	}

	/*
	 * La methode ecrire ecrit a l'ecran la liste ordonnee des donnees contenues par la liste.
	 * Par exemple, si la liste contient les entiers 2, 12, 17 et 25, la methode ecrit :
	 * Contenu de la liste : 2 12 17 25
	 */
	public void ecrire() {
		Maillon m=debut;
		StringBuilder s=new StringBuilder();
		
		do{
			
			s.append(m.getDonnee()+" ");
			m=m.getSuivant();
		}while(m.getSuivant()!=null);
		
		System.out.println("Contenu de la liste "+s);
	}

	/* 
	 * La methode ecrireDecroissant ecrit a l'ecran le contenu de la liste dans
	 * l'ordre decroissant des valeurs.  
	 * Par exemple, si la liste contient les entiers 2, 12, 17 et 25, la methode retourne :
	 * Liste dans l'ordre decroissant : 25 17 12 2
	 * Cette methode devra etre de complexite de l'ordre de la longueur de la liste et
         * utilisera de preference une methode privee recursive.
	 */
	public void ecrireDecroissant() {
	}
	
	public boolean estVide() {
		
		return debut==null && fin==null;
	}

	/* 
	 * La methode toString redefinit la methode toString de la classe Object. 
	 * Elle retourne un objet de type String decrivant la liste.
	 * Par exemple, si la liste contient les entiers 2, 12, 17 et 25, la methode retourne :
	 * Contenu de la liste : 2 12 17 25
         * Cette methode utilisera la methode concat de la classe String
	 */
	@Override
	public String toString() {
		return null;
	}
}

