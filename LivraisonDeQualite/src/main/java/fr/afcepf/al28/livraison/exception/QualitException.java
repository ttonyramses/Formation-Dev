package fr.afcepf.al28.livraison.exception;
/**
 * Classe pour les {@link Exception} de
 * l'application.
 * @author stagiaire
 *
 */
public class QualitException extends Exception {
    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Code d'erreur de l'exception.
     */
    private QualitEnum codeErreur =
            QualitEnum.CA_MARCHE_PAS;
    /**
     * @param paramMessage le message.
     * @param paramCodeErreur le code d'erreur.
     */
    public QualitException(String paramMessage, QualitEnum paramCodeErreur) {
        super(paramMessage);
        codeErreur = paramCodeErreur;
    }

    /**
     * @return the codeErreur
     */
    public QualitEnum getCodeErreur() {
        return codeErreur;
    }

    /**
     * @param paramCodeErreur the codeErreur to set
     */
    public void setCodeErreur(QualitEnum paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }

    /**
     * Default Constructor.
     */
    public QualitException() {
        super();
    }

    /**
     * @param paramMessage le message.
     */
    public QualitException(String paramMessage) {
        super(paramMessage);
    }
}
