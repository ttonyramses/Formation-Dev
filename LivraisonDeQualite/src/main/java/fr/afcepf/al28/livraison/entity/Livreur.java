package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;

/**
 * entité reprensentant un Livreur. (Nour)
 * @author stagiaire
 *
 */
public class Livreur implements Serializable {
    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * identifiant unique.
     */
    private Integer id;
    /**
     * nom du {@link Livreur}.
     */
    private String nom;
    /**
     * prenom du {@link Livreur}.
     */
    private String prenom;
    /**
     * @param paramId l'identifiant.
     * @param paramNom le nom.
     * @param paramPrenom le prenom.
     */
    public Livreur(Integer paramId,
            String paramNom, String paramPrenom) {
        super();
        id = paramId;
        nom = paramNom;
        prenom = paramPrenom;
    }
    /**
     * Default Constructor.
     */
    public Livreur() {
        super();
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param paramPrenom the prenom to set
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }
}
