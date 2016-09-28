package fr.afcepf.al28.livraison.data.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
 * DataSource pour acceder a l'unite de persistence.
 * @author stagiaire
 *
 */
public class DataSourceQualite implements DataSource {
    /**
     * JNDI name for path to database.
     */
    private static String url;
    /**
     * username for database access.
     */
    private static String login;
    /**
     * password for database access.
     */
    private static String password;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("qualite");
        url = rb.getString("url");
        login = rb.getString("login");
        password = rb.getString("password");
        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException paramE) {
            paramE.printStackTrace();
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter paramArg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int paramArg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isWrapperFor(Class<?> paramArg0) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> paramArg0) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection(String paramArg0,
            String paramArg1) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
