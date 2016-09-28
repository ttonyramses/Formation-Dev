package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * entité representant le Commande a preparer.
 * @author stagiaire
 *
 */
public class Commande implements Serializable {
    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * identifiant unique de la commande.
     */
    private Integer numero;
    /**
     * etat de la commande.
     */
    private String etat;
    /**
     * date de la commande.
     */
    private Date dateCommande;
    /**
     * lignes de commande.
     */
    private List<LigneCommande> lignes;
    /**
     * son preparateur.
     */
    private Preparateur preparateur;
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
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }
    /**
     * @param paramEtat the etat to set
     */
    public void setEtat(String paramEtat) {
        etat = paramEtat;
    }
    /**
     * @return the dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }
    /**
     * @param paramDateCommande the dateCommande to set
     */
    public void setDateCommande(Date paramDateCommande) {
        dateCommande = paramDateCommande;
    }
    /**
     * @return the lignes
     */
    public List<LigneCommande> getLignes() {
        return lignes;
    }
    /**
     * @param paramLignes the lignes to set
     */
    public void setLignes(List<LigneCommande> paramLignes) {
        lignes = paramLignes;
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
     * @param paramNumero le numero.
     * @param paramEtat l'etat.
     * @param paramDateCommande la date de la commande.
     * @param paramPreparateur le preparateur de cette commande.
     */
    public Commande(Integer paramNumero,
            String paramEtat,
            Date paramDateCommande,
            Preparateur paramPreparateur) {
        super();
        numero = paramNumero;
        etat = paramEtat;
        dateCommande = paramDateCommande;
        preparateur = paramPreparateur;
    }
    /**
     * Default Constructor.
     */
    public Commande() {
        super();
    }
}
