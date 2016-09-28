package fr.afcepf.al28.livraison.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.data.impl.DaoPreparateur;
import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * test de la methode seConnecter du DAO.
 * @author stagiaire
 *
 */
public class TestDaoPreparateurSeConnecter {
    /**
     * un login valide dans la BDD test.
     */
    private String loginValide = "test1";
    /**
     * un mot de passe valide dans la BDD test associé au loginValide.
     */
    private String mdpValide = "test1";
    /**
     * un login qui n'existe pas dans la BDD test.
     */
    private String loginInvalide = "prep@rate.ur";
    /**
     * le preparateur attendu dans le cas nominal.
     */
    private Preparateur preparateurExpected =
        new Preparateur(1, "preparateur test1",
                loginValide, null);
    /**
     * la definition du service a tester.
     */
    private IDaoPreparateur dao = new DaoPreparateur();
    /**
     * Avant tous les tests, on re-genere la bdd.
     */
    @Before
    public void setUp() {
        String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("crebase.bat").getPath();
        path = path.replaceAll("%20", " ");
        try {
            Process proc = Runtime.getRuntime().exec(path);
            proc.waitFor();
        } catch (IOException paramE) {
            paramE.printStackTrace();
        } catch (InterruptedException paramE) {
            paramE.printStackTrace();
        }
    }
    /**
     * Test du cas Nominal, avec un bon login et mdp.
     * @throws QualitException il ne doit pas passer par ici.
     */
    @Test
    public void testConnectionNominale() throws QualitException {
        Preparateur p = dao.seConnecter(loginValide, mdpValide);
        Assert.assertNotNull(p);
        Assert.assertNotNull(p.getId());
        Assert.assertNotNull(p.getNom());
        Assert.assertNotNull(p.getLogin());
        Assert.assertNull(p.getMdp());
        Assert.assertEquals(preparateurExpected.getId(),
                p.getId());
        Assert.assertEquals(preparateurExpected.getNom(),
                p.getNom());
        Assert.assertEquals(preparateurExpected.getLogin(),
                p.getLogin());
    }
    /**
     * Test du cas d'echec.
     */
    @Test
    public void testConnectionEchec() {
        try {
            dao.seConnecter(loginInvalide, mdpValide);
            Assert.fail("c'est pas normal ...");
        } catch (QualitException paramE) {
            Assert.assertEquals(
                QualitEnum.PROBLEME_IDENTIFICATION,
                paramE.getCodeErreur());
        }
    }
    /**
     * Test du cas d'echec2.
     * @throws QualitException vrai car cas d'erreur.
     */
    @Test(expected = QualitException.class)
    public void testConnectionEchecE() throws QualitException {
        dao.seConnecter(loginInvalide, mdpValide);
    }
}
