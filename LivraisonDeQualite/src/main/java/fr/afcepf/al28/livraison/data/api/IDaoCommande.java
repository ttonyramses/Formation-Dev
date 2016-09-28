package fr.afcepf.al28.livraison.data.api;

import java.util.List;

import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services pour la persistence de l'entité
 * {@link Commande}.
 * @author stagiaire
 *
 */
public interface IDaoCommande {
    /**
     * Permet de rechercher des {@link Commande}
     * ayant un etat "a preparer".
     * @return
     * <ul>
     * <li><strong>toutes</strong> les
     * {@link Commande} trouvées dans l'unité
     * de persistence.</li>
     * <li>Une {@link List} vide si tout
     * a déjà été livré</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>si l'unité de persistence ne repond pas</li>
     *  <li>erreur du dév, mais faut pas le dire</li>
     * </ul>
     */
    List<Commande> rechercherCommandeAExpedier()
        throws QualitException;
    /**
     * Permet de mettre a jour un {@link Commande} dans
     * l'unité de persistence.
     * @param cmd la {@link Commande} à mettre a jour.
     * @return la {@link Commande} modifiée.
     * @throws QualitException
     * <ul>
     *  <li>un attribut obligatoire non renseigné</li>
     *  <li>la {@link Commande} n'existe pas</li>
     *  <li>si l'unité de persistence ne repond pas</li>
     *  <li>erreur du dév, mais faut pas le dire</li>
     * </ul>
     */
    Commande maj(Commande cmd)
        throws QualitException;
}
