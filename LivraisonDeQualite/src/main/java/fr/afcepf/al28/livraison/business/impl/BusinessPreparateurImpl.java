package fr.afcepf.al28.livraison.business.impl;

import java.util.List;

import fr.afcepf.al28.livraison.business.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.data.api.IDaoLivraison;
import fr.afcepf.al28.livraison.data.api.IDaoLivreur;
import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.entity.Livreur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;
/**
 * Implementation des services Metier.
 * @author stagiaire
 *
 */
public class BusinessPreparateurImpl implements IBusinessPreparateur {
    /**
     * Dependence vers {@link IDaoLivreur}.
     */
    private IDaoLivreur daoLivreur;
    /**
     * Dependence vers {@link IDaoLivraison}.
     */
    private IDaoLivraison daoLivraison;
    @Override
    public Livraison creer(Livraison paramLiv) throws QualitException {
        List<Livreur> livreurs = daoLivreur.rechercher(
                paramLiv.getDateDepart());
        if (livreurs.isEmpty()) {
            throw new QualitException("nour pas rentré",
                    QualitEnum.PAS_DE_LIVREUR_DISPO);
        } else {
            paramLiv.setLivreur(livreurs.get(0));
            paramLiv = daoLivraison.creer(paramLiv);
        }
        return paramLiv;
    }

    /**
     * Pour injection CDI ou Spring ou EJB.
     * @param paramDaoLivreur the daoLivreur to set
     */
    public void setDaoLivreur(IDaoLivreur paramDaoLivreur) {
        daoLivreur = paramDaoLivreur;
    }
    /**
     * Pour injection CDI ou Spring ou EJB.
     * @param paramDaoLivraison the daoLivraison to set
     */
    public void setDaoLivraison(IDaoLivraison paramDaoLivraison) {
        daoLivraison = paramDaoLivraison;
    }

}
