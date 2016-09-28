package fr.afcepf.al28.livraison.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.afcepf.al28.livraison.business.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.business.impl.BusinessPreparateurImpl;
import fr.afcepf.al28.livraison.data.api.IDaoLivraison;
import fr.afcepf.al28.livraison.data.api.IDaoLivreur;
import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.entity.Livreur;
import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Test de la creation d'une livraison par le {@link Preparateur}
 * dans la couche Business de l'application.
 * @author stagiaire
 *
 */
public class TestBusinessCreationLivraisonAvecMockData {
    /**
     * Date prevue de la livraison nominale.
     */
    private static String dateDepartNominale = "31/12/2016 23:50";
    /**
     * Date prevue de la livraison Echec
     * pas de livreurs a cette date & heure.
     */
    private static String dateDepartEchec = "22/09/2016 09:30";
    /**
     * pour la manipulation des dates.
     */
    private static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * Identifiant du preparateur.
     */
    private static final int ID_PREPARATEUR = 1;
    /**
     * le preparateur de la {@link Commande}.
     */
    private static Preparateur preparateur =
            new Preparateur(ID_PREPARATEUR,
                    "preparateur test1", "test1", null);
    /**
     * Numero de la {@link Commande} a livrer.
     */
    private static final int NUMERO_COMMANDE = 6;
    /**
     * La commande a livrer.
     */
    private static Commande commande =
            new Commande(NUMERO_COMMANDE, "preparee", null,
                    preparateur);
    /**
     * Api contenant le service a tester.
     */
    private static IBusinessPreparateur bu =
            new BusinessPreparateurImpl();
    /**
     * Exception atetndue dans le cas d'echec.
     */
    private static QualitEnum expectedEchec =
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
    private static Livreur expectedLivreur =
            new Livreur(ID_NOUR, "nour", "nour");
    /**
     * Livraison attendue.
     */
    private static Livraison expectedLivraison =
            new Livraison(NUMERO_LIVRAISON,
                    null, null, preparateur, expectedLivreur,
                    commande);
    /**
     * Livraison nominam.
     */
    private static Livraison livraisonNominale =
            new Livraison(null, null, null, preparateur, null,
                    commande);
    /**
     * Livraison Echec.
     */
    private static Livraison livraisonEchec =
            new Livraison(null, null, null, preparateur, null,
                    commande);
    /**
     * Mock de la couche de persistence pour le {@link Livreur}.
     */
    private static IDaoLivreur mockDaoLivreur;
    /**
     * Mock de la couche de persistence pour la {@link Livraison}.
     */
    private static IDaoLivraison mockDaoLivraison;
    /**
     * Avant tous les tests.
     * @throws QualitException pour le mock.
     * @throws ParseException pour la date.
     */
    @BeforeClass
    public static void avantTousLesTests() throws QualitException,
                                                  ParseException {
        livraisonNominale.setDateDepart(
                sdf.parse(dateDepartNominale));
        livraisonEchec.setDateDepart(
                sdf.parse(dateDepartEchec));
        expectedLivraison.setDateDepart(
                sdf.parse(dateDepartNominale));
        mockDaoLivraison = EasyMock.createMock(IDaoLivraison.class);
        mockDaoLivreur = EasyMock.createMock(IDaoLivreur.class);
        // What did you expect?
        EasyMock.expect(mockDaoLivreur.rechercher(
                    livraisonEchec.getDateDepart()))
                .andReturn(new ArrayList<>());
        List<Livreur> liste = new ArrayList<>();
        liste.add(expectedLivreur);
        EasyMock.expect(mockDaoLivreur.rechercher(
                    livraisonNominale.getDateDepart()))
                .andReturn(liste);
        EasyMock.expect(mockDaoLivraison.creer(livraisonNominale))
                .andReturn(expectedLivraison);
        EasyMock.replay(mockDaoLivraison);
        EasyMock.replay(mockDaoLivreur);
        ((BusinessPreparateurImpl) bu)
            .setDaoLivraison(mockDaoLivraison);
        ((BusinessPreparateurImpl) bu)
            .setDaoLivreur(mockDaoLivreur);
    }
    /**
     * Après tous les tests.
     */
    @AfterClass
    public static void apresTousLesTests() {
        EasyMock.verify(mockDaoLivraison);
        EasyMock.verify(mockDaoLivreur);
    }
    /**
     * Test du cas ou 'Nour' est dispo.
     * @throws QualitException on ne doit pas passer ici!!!
     */
    @Test
    public void testNoninal() throws QualitException {
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
