package fr.afcepf.al28.livraison.business.api;

import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services metier liés a la preparation et la livraison
 * d'une {@link Commande}.
 * @author stagiaire
 *
 */
public interface IBusinessPreparateur {
    /**
     * Le preparateur creer une livraison pour une
     * date de depart donnée, une commande donnée
     * et un livreur donné.
     * @param liv la livraison
     * @return la {@link Livraison} créée.
     * @throws QualitException
     * <ul>
     *  <li>Pas de livreurs disponible a la date choisie</li>
     *  <li>Si la couche de persistence lève une exception</li>
     * </ul>
     */
    Livraison creer(Livraison liv) throws QualitException;
}
