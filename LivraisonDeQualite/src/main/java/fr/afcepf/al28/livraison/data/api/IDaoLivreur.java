package fr.afcepf.al28.livraison.data.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.al28.livraison.entity.Livreur;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services li�s � la persistence de l'entit�
 * {@link Livreur}.
 * @author stagiaire
 *
 */
public interface IDaoLivreur {
    /**
     * M�thode permettant de recherche tous les {@link Livreur}
     * disponible � une date (et heure) donn�e.
     * @param date la date recherch�e.
     * @return
     * <ul>
     *  <li><strong>tous les {@link Livreur} dispo</strong>
     *  </li>
     *  <li>une {@link List} vide si personne de dispo</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>si l'unit� de persistence ne repond pas</li>
     *  <li>erreur du d�v, mais faut pas le dire</li>
     * </ul>
     */
    List<Livreur> rechercher(Date date)
            throws QualitException;
}
