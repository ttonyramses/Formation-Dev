package fr.afcepf.al28.livraison.data.api;

import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitException;

/**
 * Services li�s a la persistence de l'entit�
 * {@link Preparateur}.
 * @author stagiaire
 *
 */
public interface IDaoPreparateur {
    /**
     * Methode permettant de verifier l'existance
     * d'un {@link Preparateur} dans l'unit� de
     * persistence � l'aide d'un login et d'un mot
     * de passe.
     * @param login le login.
     * @param mdp le mot de passe.
     * @return un {@link Preparateur} existant.
     * @throws QualitException
     * <ul>
     *  <li>aucun {@link Preparateur} avec ce
     *  login/mot de passe.</li>
     *  <li>l'unit� de persistence est cass�e.</li>
     * </ul>
     */
    Preparateur seConnecter(String login, String mdp)
            throws QualitException;
}
