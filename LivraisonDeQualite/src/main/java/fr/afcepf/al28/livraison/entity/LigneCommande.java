package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;

/**
 * Entité representant les Lignes de Commande.
 * @author stagiaire
 *
 */
public class LigneCommande implements Serializable {

    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique de la ligne de commande.
     */
    private Integer id;
    /**
     * quantité de produit.
     */
    private Integer qte;
    /**
     * le {@link Produit} concerné.
     */
    private Produit pdt;
    /**
     * la {@link Commande} concernée.
     */
    private Commande cmd;
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
     * @return the qte
     */
    public Integer getQte() {
        return qte;
    }
    /**
     * @param paramQte the qte to set
     */
    public void setQte(Integer paramQte) {
        qte = paramQte;
    }
    /**
     * @return the pdt
     */
    public Produit getPdt() {
        return pdt;
    }
    /**
     * @param paramPdt the pdt to set
     */
    public void setPdt(Produit paramPdt) {
        pdt = paramPdt;
    }
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
     * Constructeur surcharg".
     * @param paramId l'identifiant.
     * @param paramQte la quantite.
     * @param paramPdt le produit.
     * @param paramCmd la commande.
     */
    public LigneCommande(Integer paramId,
            Integer paramQte, Produit paramPdt, Commande paramCmd) {
        super();
        id = paramId;
        qte = paramQte;
        pdt = paramPdt;
        cmd = paramCmd;
    }
    /**
     * Default Constructor.
     */
    public LigneCommande() {
        super();
    }
}
