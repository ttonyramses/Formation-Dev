package fr.afcepf.al28.livraison.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import fr.afcepf.al28.livraison.business.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.business.impl.BusinessPreparateurImpl;
import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.entity.Livreur;
import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;
import org.junit.Assert;

/**
 * Test de la creation d'une livraison par le {@link Preparateur}
 * dans la couche Business de l'application.
 * @author stagiaire
 *
 */
public class TestBusinessCreationLivraison {
    /**
     * Date prevue de la livraison nominale.
     */
    private String dateDepartNominale = "31/12/2016 23:50";
    /**
     * Date prevue de la livraison Echec
     * pas de livreurs a cette date & heure.
     */
    private String dateDepartEchec = "22/09/2016 09:30";
    /**
     * pour la manipulation des dates.
     */
    private SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * Identifiant du preparateur.
     */
    private static final int ID_PREPARATEUR = 1;
    /**
     * le preparateur de la {@link Commande}.
     */
    private Preparateur preparateur =
            new Preparateur(ID_PREPARATEUR,
                    "preparateur test1", "test1", null);
    /**
     * Numero de la {@link Commande} a livrer.
     */
    private static final int NUMERO_COMMANDE = 6;
    /**
     * La commande a livrer.
     */
    private Commande commande =
            new Commande(NUMERO_COMMANDE, "preparee", null,
                    preparateur);
    /**
     * Api contenant le service a tester.
     */
    private IBusinessPreparateur bu =
            new BusinessPreparateurImpl() {
        /**
         * Mock de la methode creer.
         */
        @Override
        public Livraison creer(Livraison paramLiv)
                throws QualitException {
            if (paramLiv == livraisonNominale) {
                paramLiv.setLivreur(expectedLivreur);
                paramLiv.setNumero(NUMERO_LIVRAISON);
            } else {
                throw new QualitException("",
                        QualitEnum.PAS_DE_LIVREUR_DISPO);
            }
            return paramLiv;
        }
    };
    /**
     * Exception atetndue dans le cas d'echec.
     */
    private QualitEnum expectedEchec =
            QualitEnum.PAS_DE_LIVREUR_DISPO;
    /**
     * identifiant de la livraison attendue.
     */
    private static final int NUMERO_LIVRAISON = 6;
    /**
     * Identifiant de Nour.
     */
    private static final int ID_NOUR = 1;
    /**
     * Livreur de la livraison nominale.
     */
    private Livreur expectedLivreur =
            new Livreur(ID_NOUR, "nour", "nour");
    /**
     * Livraison attendue.
     */
    private Livraison expectedLivraison =
            new Livraison(NUMERO_LIVRAISON,
                    null, null, preparateur, expectedLivreur,
                    commande);
    /**
     * Livraison nominam.
     */
    private Livraison livraisonNominale =
            new Livraison(null, null, null, preparateur, null,
                    commande);
    /**
     * Livraison Echec.
     */
    private Livraison livraisonEchec =
            new Livraison(null, null, null, preparateur, null,
                    commande);
    /**
     * Contructor.
     */
    public TestBusinessCreationLivraison() {
        try {
            livraisonNominale.setDateDepart(
                    sdf.parse(dateDepartNominale));
            livraisonEchec.setDateDepart(
                    sdf.parse(dateDepartEchec));
            expectedLivraison.setDateDepart(
                    sdf.parse(dateDepartNominale));
        } catch (ParseException paramE) {
            paramE.printStackTrace();
        }
    }
    /**
     * Test du cas ou 'Nour' est dispo.
     * @throws QualitException on ne doit pas passer ici!!!
     */
    @Test
    public void testNominal() throws QualitException {
        Livraison retour = bu.creer(livraisonNominale);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getNumero());
        Assert.assertNotNull(retour.getLivreur());
        Assert.assertNotNull(retour.getDateDepart());
        Assert.assertNotNull(retour.getCmd());
        Assert.assertNotNull(retour.getPreparateur());
        Assert.assertNull(retour.getDateArrivee());
        Assert.assertEquals(expectedLivraison.getNumero(),
                retour.getNumero());
        Assert.assertEquals(expectedLivraison.getDateDepart(),
                retour.getDateDepart());
        Livreur livreurRetour = retour.getLivreur();
        Assert.assertNotNull(livreurRetour.getId());
        Assert.assertNotNull(livreurRetour.getNom());
        Assert.assertNotNull(livreurRetour.getPrenom());
        Assert.assertEquals(expectedLivreur.getId(), livreurRetour.getId());
        Assert.assertEquals(expectedLivreur.getNom(), livreurRetour.getNom());
        Assert.assertEquals(expectedLivreur.getPrenom(),
                livreurRetour.getPrenom());
    }
    /**
     * Test du cas ou 'Nour' est encore en balade.
     */
    @Test
    public void testEchec() {
        try {
            bu.creer(livraisonEchec);
            Assert.fail("livraison créée ... pas normal !!!");
        } catch (QualitException paramE) {
            Assert.assertEquals(expectedEchec,
                    paramE.getCodeErreur());
        }
    }
}
