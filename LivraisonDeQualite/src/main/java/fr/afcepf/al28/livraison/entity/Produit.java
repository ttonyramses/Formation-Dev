package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Entité representant le Produit d'une Commande.
 * @author stagiaire
 *
 */
public class Produit implements Serializable {
    /**
     * numero de version pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique du produit.
     */
    private Integer id;
    /**
     * Nom du Produit.
     */
    private String nom;
    /**
     * Prix du produit.
     */
    private Float prix;
    /**
     * Les lignes de commande composées
     * de ce produit. OneToMany (souvenez vous).
     */
    private List<LigneCommande> lignes;
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
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the prix
     */
    public Float getPrix() {
        return prix;
    }
    /**
     * @param paramPrix the prix to set
     */
    public void setPrix(Float paramPrix) {
        prix = paramPrix;
    }
    /**
     * @param paramId l'identation.
     * @param paramNom le nom.
     * @param paramPrix le prix.
     */
    public Produit(Integer paramId, String paramNom, Float paramPrix) {
        super();
        id = paramId;
        nom = paramNom;
        prix = paramPrix;
    }
    /**
     * Default Constructor.
     */
    public Produit() {
        super();
    }
}
