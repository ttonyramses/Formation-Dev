
public class Test {

	public static void main(String[] args) 
	{
		CommandeHandler chaine = creerChaine();
		
		Commande c1 = new Commande(42f);
		Commande c2 = new Commande(750f);
		
		chaine.traiterCommande(c1);
		chaine.traiterCommande(c2);
		
	}
	
	public static CommandeHandler creerChaine()
	{
		// création de la chaine :
		VendeurHandler vendeur = new VendeurHandler();
		FacturationHandler factu = new FacturationHandler();
		LogistiqueHandler logi = new LogistiqueHandler();
		ExpeditionHandler expe = new ExpeditionHandler();
		TransportHandler transp = new TransportHandler();
				
		vendeur.setSuccesseur(factu);
		factu.setSuccesseur(logi);
		logi.setSuccesseur(expe);
		expe.setSuccesseur(transp);
		return vendeur;
	}

}
