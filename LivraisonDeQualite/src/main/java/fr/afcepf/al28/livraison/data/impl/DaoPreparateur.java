package fr.afcepf.al28.livraison.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.entity.Preparateur;
import fr.afcepf.al28.livraison.exception.QualitEnum;
import fr.afcepf.al28.livraison.exception.QualitException;
/**
 * Implementation JDBC pour les services
 * de l'entité {@link Preparateur}.
 * @author stagiaire
 *
 */
public class DaoPreparateur implements IDaoPreparateur {
    /**
     * Connect sql request.
     */
    private static final String REQ_CONNECT =
        "SELECT id_preparateur, nom_preparateur, login_preparateur "
        + "FROM preparateur WHERE login_preparateur = ?"
        + " AND password_preparateur = ?";
    /**
     * index du parametre login dans la requete Connect.
     */
    private static final int INDEX_PARAM_LOGIN_REQUEST = 1;
    /**
     * index du parametre password dans la requete Connect.
     */
    private static final int INDEX_PARAM_PASSWORD_REQUEST = 2;
    /**
     * index de la colonne id de la requete Connect.
     */
    private static final int INDEX_COL_ID_RESULT = 1;
    /**
     * index de la colonne nom de la requete Connect.
     */
    private static final int INDEX_COL_NOM_RESULT = 2;
    /**
     * index de la colonne LOGIN de la requete Connect.
     */
    private static final int INDEX_COL_LOGIN_RESULT = 3;
    /**
     * DataSource for JDBC Connection.
     */
    private DataSource ds = new DataSourceQualite();
    @Override
    public Preparateur seConnecter(String paramLogin,
            String paramMdp) throws QualitException {
        Connection cnx = null;
        QualitException qe = null;
        Preparateur preparateur = new Preparateur();
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(REQ_CONNECT);
            pstmt.setString(INDEX_PARAM_LOGIN_REQUEST, paramLogin);
            pstmt.setString(INDEX_PARAM_PASSWORD_REQUEST, paramMdp);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                preparateur.setId(rs.getInt(INDEX_COL_ID_RESULT));
                preparateur.setLogin(rs.getString(INDEX_COL_LOGIN_RESULT));
                preparateur.setNom(rs.getString(INDEX_COL_NOM_RESULT));
            } else {
                qe = new QualitException("mauvais login / pass",
                        QualitEnum.PROBLEME_IDENTIFICATION);
            }
        } catch (Exception paramE) {
            qe = new QualitException(paramE.getMessage(),
                    QualitEnum.CA_MARCHE_PAS);
        } finally {
            try {
                cnx.close();
            } catch (Exception paramE) {
                qe = new QualitException(paramE.getMessage(),
                        QualitEnum.PROBLEME_CONNECTION_SQL);
            }
        }
        if (qe != null) {
            throw qe;
        }
        return preparateur;
    }

}
