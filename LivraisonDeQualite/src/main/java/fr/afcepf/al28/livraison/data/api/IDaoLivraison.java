package fr.afcepf.al28.livraison.data.api;

import fr.afcepf.al28.livraison.entity.Livraison;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services de persistence pour l'entit� {@link Livraison}.
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
     *  <li>propri�t� obligatoire non renseign�e ou
     *  au mauvais format</li>
     *  <li>livraison existe d�j�</li>
     *  <li>si l'unit� de persistence ne repond pas</li>
     *  <li>erreur du d�v, mais faut pas le dire</li>
     * </ul>
     */
    Livraison creer(Livraison liv)
        throws QualitException;
}
