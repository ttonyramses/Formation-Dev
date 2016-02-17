/*
 * Fichier com/eteks/test/CalculTotalFactures.java
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
package com.eteks.test;

import java.sql.*;
import javax.swing.JOptionPane;

class CalculTotalFactures
{
  public static void main(String[] args)
  {
    try
    {
      // Chargement de la classe du driver JDBC de MySQL
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException ex)
    {
      JOptionPane.showMessageDialog(null,
             "Classe de driver introuvable " + ex.getMessage());
      System.exit(0);
    }

    Connection connexion = null;
    Statement  instruction  = null;
    ResultSet  resultat = null;
    try
    {
      // Ouverture de la connexion avec MySQL tournant sur la meme machine
      connexion = DriverManager.getConnection(
                                         "jdbc:mysql:///test");
      instruction = connexion.createStatement();
      // Creation de la table FACTURE et de ses enregistrements
      instruction.executeUpdate(
          "CREATE TABLE FACTURE(CLIENT CHAR(50),"
          + " ARTICLE VARCHAR(255), MONTANT DECIMAL(9,2))");
      instruction.executeUpdate(
          "INSERT INTO FACTURE (CLIENT, ARTICLE, MONTANT)"
          + " VALUES ('Thomas Durand', 'CDRx10', '6.35')");
      instruction.executeUpdate(
          "INSERT INTO FACTURE (CLIENT, ARTICLE, MONTANT)"
          + " VALUES ('Sophie Martin', 'PC', '1500')");
      instruction.executeUpdate(
          "INSERT INTO FACTURE (CLIENT, ARTICLE, MONTANT)"
          + " VALUES ('Sophie Martin', 'Imprimante', '120.5')");
      // Recherche dans la table FACTURE et exploitation du resultat
      resultat = instruction.executeQuery(
          "SELECT ARTICLE, MONTANT FROM FACTURE"
          + " WHERE CLIENT='Sophie Martin'");
      String articles = "";
      double montantTotal = 0;
      // Boucle vraie tant qu'il y a des enregistrements trouves
      while (resultat.next())
      {
        articles += resultat.getString("ARTICLE") + " ";
        montantTotal += resultat.getDouble("MONTANT");
      }
      JOptionPane.showMessageDialog(null,
          "Articles : " + articles
          + "\nMontant total : " + montantTotal + " \u20ac");
      // Suppression de la table FACTURE
      instruction.executeUpdate("DROP TABLE FACTURE");
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null,
             "Erreur JDBC : " + ex.getMessage());
    }
    finally
    {
      try
      {
        if (resultat != null)
          resultat.close();
        if (instruction != null)
          instruction.close();
        if (connexion != null)
          connexion.close();
      }
      catch (SQLException ex)
      {
        ex.printStackTrace ();
      }
    }
  }
}
