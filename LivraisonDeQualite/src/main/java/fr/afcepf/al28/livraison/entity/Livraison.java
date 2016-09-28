package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author stagiaire
 *
 */
public class Livraison implements Serializable {

    /**
     * pour les EJBs.
     */
    private static final long serialVersionUID = 1L;
    /**
     * identifiant unique de la {@link Livraison}.
     */
    private Integer numero;
    /**
     * quand est partit Nour ({@link Livreur}).
     */
    private Date dateDepart;
    /**
     * quand il a livré la {@link Commande}.
     */
    private Date dateArrivee;
    /**
     * qui l'a envoyé en mission vélo.
     */
    private Preparateur preparateur;
    /**
     * instanceOf(Nour).
     */
    private Livreur livreur;
    /**
     * la commande livrée.
     */
    private Commande cmd;
    /**
     * @return the cmd
     */
    public Commande getCmd() {
        return cmd;
    }
    /**
     * @param paramCmd the cmd to set
     */
    public void setCmd(Commande paramCmd) {
        cmd = paramCmd;
    }
    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }
    /**
     * @param paramNumero the numero to set
     */
    public void setNumero(Integer paramNumero) {
        numero = paramNumero;
    }
    /**
     * @return the dateDepart
     */
    public Date getDateDepart() {
        return dateDepart;
    }
    /**
     * @param paramDateDepart the dateDepart to set
     */
    public void setDateDepart(Date paramDateDepart) {
        dateDepart = paramDateDepart;
    }
    /**
     * @return the dateArrivee
     */
    public Date getDateArrivee() {
        return dateArrivee;
    }
    /**
     * @param paramDateArrivee the dateArrivee to set
     */
    public void setDateArrivee(Date paramDateArrivee) {
        dateArrivee = paramDateArrivee;
    }
    /**
     * @return the preparateur
     */
    public Preparateur getPreparateur() {
        return preparateur;
    }
    /**
     * @param paramPreparateur the preparateur to set
     */
    public void setPreparateur(Preparateur paramPreparateur) {
        preparateur = paramPreparateur;
    }
    /**
     * @return the livreur
     */
    public Livreur getLivreur() {
        return livreur;
    }
    /**
     * @param paramLivreur the livreur to set
     */
    public void setLivreur(Livreur paramLivreur) {
        livreur = paramLivreur;
    }
    /**
     * @param paramNumero numero.
     * @param paramDateDepart date depart.
     * @param paramDateArrivee date arrivée.
     * @param paramPreparateur le preparateur.
     * @param paramLivreur le livreur.
     */
    public Livraison(Integer paramNumero,
            Date paramDateDepart,
            Date paramDateArrivee,
            Preparateur paramPreparateur,
            Livreur paramLivreur) {
        super();
        numero = paramNumero;
        dateDepart = paramDateDepart;
        dateArrivee = paramDateArrivee;
        preparateur = paramPreparateur;
        livreur = paramLivreur;
    }
    /**
     * @param paramNumero numero.
     * @param paramDateDepart date depart.
     * @param paramDateArrivee date arrivée.
     * @param paramPreparateur le preparateur.
     * @param paramLivreur le livreur.
     * @param paramCmd la commande.
     */
    public Livraison(Integer paramNumero,
            Date paramDateDepart, Date paramDateArrivee,
            Preparateur paramPreparateur,
            Livreur paramLivreur, Commande paramCmd) {
        super();
        numero = paramNumero;
        dateDepart = paramDateDepart;
        dateArrivee = paramDateArrivee;
        preparateur = paramPreparateur;
        livreur = paramLivreur;
        cmd = paramCmd;
    }
    /**
     * Default Constructor.
     */
    public Livraison() {
        super();
    }
}
