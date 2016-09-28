package fr.afcepf.al28.livraison.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * entité definissant le Preparateur de {@link Commande}.
 * @author stagiaire
 *
 */
@Entity
public class Preparateur implements Serializable {
    /**
     * pour la serialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_preparateur")
    private Integer id;
    /**
     * nom du {@link Preparateur}.
     */
    @Column(name="nom_preparateur", nullable = false, length = 45)
    private String nom;
    /**
     * login du {@link Preparateur}.
     */
    @Column(name="login_preparateur", nullable = false, length = 45)
    private String login;
    /**
     * mot de passe du {@link Preparateur}.
     */
    @Column(name="password_preparateur", nullable = false, length = 45)
    private String mdp;
    /**
     * les {@link Commande} preparées par le
     * {@link Preparateur}.
     */
    @Transient
    private List<Commande> commandesPreparees;
    /**
     * Les {@link Livraison} créées par le
     * {@link Preparateur}.
     */
    @Transient
    private List<Livraison> livraisonsCreees;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param paramLogin the login to set
     */
    public void setLogin(String paramLogin) {
        login = paramLogin;
    }
    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }
    /**
     * @param paramMdp the mdp to set
     */
    public void setMdp(String paramMdp) {
        mdp = paramMdp;
    }
    /**
     * @return the commandesPreparees
     */
    public List<Commande> getCommandesPreparees() {
        return commandesPreparees;
    }
    /**
     * @param paramCommandesPreparees the commandesPreparees to set
     */
    public void setCommandesPreparees(List<Commande> paramCommandesPreparees) {
        commandesPreparees = paramCommandesPreparees;
    }
    /**
     * @return the livraisonsCreees
     */
    public List<Livraison> getLivraisonsCreees() {
        return livraisonsCreees;
    }
    /**
     * @param paramLivraisonsCreees the livraisonsCreees to set
     */
    public void setLivraisonsCreees(List<Livraison> paramLivraisonsCreees) {
        livraisonsCreees = paramLivraisonsCreees;
    }
    /**
     * @param paramId l'identifiant.
     * @param paramNom le nom.
     * @param paramLogin le login.
     * @param paramMdp le mot de passe.
     */
    public Preparateur(Integer paramId,
            String paramNom,
            String paramLogin, String paramMdp) {
        super();
        id = paramId;
        nom = paramNom;
        login = paramLogin;
        mdp = paramMdp;
    }
    /**
     * Default constructor.
     */
    public Preparateur() {
        super();
    }
}
