package fr.afcepf.al28.livraison.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * 
 * @author stagiaire
 *
 */
@Remote(IDaoPreparateur.class)
@Stateless
public class DaoPreparateurEJB implements IDaoPreparateur{

    /**
     * Definition de l'entitymanager injecté par le container.
     */
    @PersistenceContext(unitName="livraison_unit")
    private EntityManager em;
    
    @Override
    public Preparateur seConnecter(String paramLogin, String paramMdp) throws QualitException {
        
        Preparateur prepa = null;
        
        Query query = em.createQuery("SELECT p FROM Preparateur p WHERE p.login = :plogin "
                + " AND p.mdp = :pmdp")
                .setParameter("plogin", paramLogin)
                .setParameter("pmdp", paramMdp);
                
        
        try {
            prepa = (Preparateur) query.getSingleResult();
        } catch (Exception paramE) {
            throw new QualitException("Authentification echouée", QualitEnum.PROBLEME_IDENTIFICATION);
        }
        return prepa;
    }

}
