package fr.afcepf.al28.livraison.business.api;

import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services metier li�s a la preparation et la livraison
 * d'une {@link Commande}.
 * @author stagiaire
 *
 */
public interface IBusinessPreparateur {
    /**
     * Le preparateur creer une livraison pour une
     * date de depart donn�e, une commande donn�e
     * et un livreur donn�.
     * @param liv la livraison
     * @return la {@link Livraison} cr��e.
     * @throws QualitException
     * <ul>
     *  <li>Pas de livreurs disponible a la date choisie</li>
     *  <li>Si la couche de persistence l�ve une exception</li>
     * </ul>
     */
    Livraison creer(Livraison liv) throws QualitException;
}
