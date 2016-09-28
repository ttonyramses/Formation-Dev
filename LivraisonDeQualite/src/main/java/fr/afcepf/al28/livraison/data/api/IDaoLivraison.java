package fr.afcepf.al28.livraison.data.api;

import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services de persistence pour l'entité {@link Livraison}.
 * @author stagiaire
 *
 */
public interface IDaoLivraison {
    /**
     * Permet de faire persister une {@link Livraison}.
     * @param liv la {@link Livraison}.
     * @return
     * la {@link Livraison} non transient.
     * @throws QualitException
     * <ul>
     *  <li>propriété obligatoire non renseignée ou
     *  au mauvais format</li>
     *  <li>livraison existe déjà</li>
     *  <li>si l'unité de persistence ne repond pas</li>
     *  <li>erreur du dév, mais faut pas le dire</li>
     * </ul>
     */
    Livraison creer(Livraison liv)
        throws QualitException;
}
