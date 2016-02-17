/*
 * Fichier com/eteks/forum/ConnecteurForum.java
 *
 * Les Cahiers du Programmeur Java - Copyright (C) 2003-2012 Emmanuel PUYBARET / eTeks <info@eteks.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.eteks.forum;

import java.sql.*;

/**
 * Connecteur creant une connexion JDBC pour la base du forum et
 * creant les tables UTILISATEUR et MESSAGE si necessaire.
 */
public class ConnecteurForum
{
  private String     driver          = "com.mysql.jdbc.Driver";
  private String     chaineConnexion = "jdbc:mysql:/localhost/3306/forum";
  private String     login;
  private String     password;
  private Connection connexion;

  public void setDriver(String driver) throws SQLException
  {
    this.driver = driver;
    fermerConnexion();
  }
  public void setChaineConnexion(String chaineConnexion)
                                             throws SQLException
  {
    this.chaineConnexion = chaineConnexion;
    fermerConnexion();
  }

  public void setLogin(String login) throws SQLException
  {
    this.login = login;
    fermerConnexion();
  }

  public void setPassword(String password) throws SQLException
  {
    this.password = password;
    fermerConnexion();
  }

  public void fermerConnexion() throws SQLException
  {
    if (this.connexion != null && !this.connexion.isClosed())
      this.connexion.close();
  }

  public Connection getConnexion() throws SQLException
  {
    try
    {
      if (this.connexion == null || this.connexion.isClosed())
      {
        Class.forName(driver);
        if (login != null)
          this.connexion = DriverManager.getConnection(
                this.chaineConnexion, this.login, this.password);
        else
          this.connexion = DriverManager.getConnection(
                this.chaineConnexion);
        verifierTables(this.connexion);
      }
      return this.connexion;
    }
    catch (ClassNotFoundException ex)
    {
      throw new SQLException(
                   "Classe introuvable " + ex.getMessage());
    }
  }

  protected void verifierTables(Connection connexion)
                                    throws SQLException
  {
    if (!verifierTable(connexion, "UTILISATEUR"))
      try (Statement instruction = connexion.createStatement())
      {
        instruction.executeUpdate("CREATE TABLE UTILISATEUR"
            + " (PSEUDONYME CHAR(30), MOTDEPASSE CHAR(30),"
            + " AUTORISATION CHAR(1))");
        instruction.executeUpdate("CREATE INDEX INDEXPSEUDO"
            + " ON UTILISATEUR (PSEUDONYME)");
      }
    if (!verifierTable(connexion, "MESSAGE"))
      try (Statement instruction = connexion.createStatement())
      {
        instruction.executeUpdate("CREATE TABLE MESSAGE"
          + " (ID INTEGER, AUTEUR CHAR(30), DATECREATION"
          + " TIMESTAMP, SUJET VARCHAR(255), TEXTE VARCHAR(4000))");
        instruction.executeUpdate(
          "CREATE INDEX INDEXDATE ON MESSAGE (DATECREATION)");
        instruction.executeUpdate(
          "CREATE INDEX INDEXID ON MESSAGE (ID)");
      }
  }

  protected boolean verifierTable(Connection connexion,
                                   String table)
                                    throws SQLException
  {
    DatabaseMetaData info = connexion.getMetaData();
    try (ResultSet resultat = info.getTables(
                    connexion.getCatalog(), null, table, null)) 
    {
      return resultat.next();
    }
  }
}
