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
			fin=new Maillon(n,fin,null);
			fin.getPrecedent().setSuivant(fin);
		}
	}

	/*
	 * La methode taille renvoie le nombre de maillons de la liste, c'est-a-dire le nombre de donnees
	 */
	public int taille() {
		int t=0;
		Maillon m=debut;
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
		Maillon m=debut;
		do{
			if(m!=null && m.getDonnee()==valeur) return true;
			m=m.getSuivant();
		}while(m!=null);
		return false;
	}

	/*
	 * Si la liste est vide, la methode retirerPlusPetit envoie une exception de type VideException 
	 * (voir le fichier VideException.java fourni) ;
	 * si la liste n'est pas vide, elle retire le premier maillon de la liste
	 * et renvoie la valeur contenue par le maillon supprime
	 */
	public int retirerPlusPetit() throws VideException {

		if(estVide()) throw new VideException();


		Maillon m=debut;
		int min=Integer.MIN_VALUE;

		if(taille()==1){
			min=debut.getDonnee();
			debut=null;
			fin=null;
			return min;
		}

		try{
			min=plusPetit();
		}catch(VideException e){
			System.out.println(e);
		}

		while(m!=null){
			if(m.getDonnee()==min){
				if(m.getPrecedent()==null){
					debut=m.getSuivant();
				}else{
					m.getPrecedent().setSuivant(m.getSuivant());
				}
				
				if(m.getSuivant()==null){
					fin=m.getPrecedent();
				}else{
					m.getSuivant().setPrecedent(m.getPrecedent());
				}
					
			}
			if(m!=null)
					m=m.getSuivant();
		}
		return min;
	}

	/*
	 * Si la liste est vide, la methode plusGrand envoie une exception de type VideException ;
	 * (voir le fichier VideException.java fourni) ;
	 * si la liste n'est pas vide, elle renvoie la plus grande valeur de la liste ;
	 * la methode ne supprime pas de maillon
	 */
	public int plusGrand() throws VideException {
		if(estVide()) throw new VideException();

		int max=debut.getDonnee();
		Maillon m=debut;
		while(m!=null){
			if(m.getDonnee()>max) max=m.getDonnee();
			m=m.getSuivant();

		}

		return max;
	}

	public int plusPetit() throws VideException {
		if(estVide()) throw new VideException();

		int min=debut.getDonnee();
		Maillon m=debut;
		while(m!=null){
			if(m.getDonnee()<min) min=m.getDonnee();
			m=m.getSuivant();

		}

		return min;
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
		}while(m!=null);

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
		
		ordonnance();
		ecrire();
	}
	
	private boolean permutation(Maillon m){
		

		
		if(m.getPrecedent()==null){
			this.debut=m;
		}
		
		if(m.getSuivant()==null) {
			this.fin=m;
			return false;
		}
		
		Maillon mp=m.getPrecedent();
		Maillon ms=m.getSuivant();
		
		m.setSuivant(ms.getSuivant());
		m.setPrecedent(ms);
		ms.setSuivant(m);
		ms.setPrecedent(mp);
		if(mp!=null) mp.setSuivant(ms);
		
		return true;
	}
	
	private void ordonnance(){
		
		Maillon m=debut;

		do{
			if(m.getSuivant()!=null && m.compareTo(m.getSuivant())<0){
				if(permutation(m))	ordonnance();
			}
			m=m.getSuivant();
		}while(m!=null);
		
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

		Maillon m=debut;
		StringBuilder s=new StringBuilder();

		do{

			s.append(m.getDonnee()+" ");
			m=m.getSuivant();
		}while(m!=null);

		return s.toString();

	}
}

