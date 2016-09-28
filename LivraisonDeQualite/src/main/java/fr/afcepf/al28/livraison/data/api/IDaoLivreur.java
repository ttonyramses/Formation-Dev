package fr.afcepf.al28.livraison.data.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.al28.livraison.entity.Livreur;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services liés à la persistence de l'entité
 * {@link Livreur}.
 * @author stagiaire
 *
 */
public interface IDaoLivreur {
    /**
     * Méthode permettant de recherche tous les {@link Livreur}
     * disponible à une date (et heure) donnée.
     * @param date la date recherchée.
     * @return
     * <ul>
     *  <li><strong>tous les {@link Livreur} dispo</strong>
     *  </li>
     *  <li>une {@link List} vide si personne de dispo</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>si l'unité de persistence ne repond pas</li>
     *  <li>erreur du dév, mais faut pas le dire</li>
     * </ul>
     */
    List<Livreur> rechercher(Date date)
            throws QualitException;
}
