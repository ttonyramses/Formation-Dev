package fr.afcepf.al28.qualite;

/**
 * une classe pour qu'on ne sait pas ecrire.
 * @author stagiaire
 *
 */
public class UneClasse {

    /**
     * un autre attribut.
     */
    private int att1;

    /**
     * un autre attribut.
     */
    private String att2;


    /**
     * Contructeur par defaut.
     */
    public UneClasse() {

    }


    /**
     * @param paramAtt1 mon paramAtt1
     * @param paramAtt2 mon paramAtt2
     */
    public UneClasse(int paramAtt1, String paramAtt2) {
        super();
        att1 = paramAtt1;
        att2 = paramAtt2;
    }

    /**
     * Methode inutile.
     * @param i attribut int
     * @return <code>
     * <ul>
     *  <li><b>"coucou"</b></li>
     * </ul>
     * </code>
     */
    public String methode(int i) {
        return "coucou";
    }


    /**
     * @return the att1
     */
    public int getAtt1() {
        return att1;
    }


    /**
     * @param paramAtt1 the att1 to set
     */
    public void setAtt1(int paramAtt1) {
        att1 = paramAtt1;
    }


    /**
     * @return the att2
     */
    public String getAtt2() {
        return att2;
    }


    /**
     * @param paramAtt2 the att2 to set
     */
    public void setAtt2(String paramAtt2) {
        att2 = paramAtt2;
    }


}
