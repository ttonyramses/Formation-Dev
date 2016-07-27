package fr.afcepf.al28.tpDAO;

public class ConsoleAppTpDAO {

	public static void main(String[] args) {

		PersonneDao personneDao =new PersonneDaoImpl();
		personneDao.insertEntity(new Personne(1,"p1",42,75f));
		personneDao.insertEntity(new Personne(2,"p2",25,70.5f));
		personneDao.insertEntity(new Personne(3,"p3",8,30.5f));

		for(Personne p : personneDao.findAllPersonnes()){
			System.out.println(p);
		}

	}

}
