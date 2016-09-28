package fr.afcepf.al28.livraison.exception;

/**
 * Enumeration des erreurs possibles.
 * @author stagiaire
 *
 */
public enum QualitEnum {
    /**
     * Erreur si le metier ne trouve pas de
     * Livreur disponible lors de la creation
     * de la Livraison.
     */
    PAS_DE_LIVREUR_DISPO,
    /**
     * Le serveur de données ne repond pas.
     */
    PROBLEME_CONNECTION_SQL,
    /**
     * Mauvais Login/Password.
     */
    PROBLEME_IDENTIFICATION,
    /**
     * Erreur (Volante) Non Identifiée.
     */
    CA_MARCHE_PAS
}
