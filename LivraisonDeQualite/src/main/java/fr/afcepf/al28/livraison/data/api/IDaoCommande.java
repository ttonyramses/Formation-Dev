package fr.afcepf.al28.livraison.data.api;

import java.util.List;

import fr.afcepf.al28.livraison.entity.Commande;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services pour la persistence de l'entit�
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
     * {@link Commande} trouv�es dans l'unit�
     * de persistence.</li>
     * <li>Une {@link List} vide si tout
     * a d�j� �t� livr�</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>si l'unit� de persistence ne repond pas</li>
     *  <li>erreur du d�v, mais faut pas le dire</li>
     * </ul>
     */
    List<Commande> rechercherCommandeAExpedier()
        throws QualitException;
    /**
     * Permet de mettre a jour un {@link Commande} dans
     * l'unit� de persistence.
     * @param cmd la {@link Commande} � mettre a jour.
     * @return la {@link Commande} modifi�e.
     * @throws QualitException
     * <ul>
     *  <li>un attribut obligatoire non renseign�</li>
     *  <li>la {@link Commande} n'existe pas</li>
     *  <li>si l'unit� de persistence ne repond pas</li>
     *  <li>erreur du d�v, mais faut pas le dire</li>
     * </ul>
     */
    Commande maj(Commande cmd)
        throws QualitException;
}
