/*
 * Fichier com/eteks/test/TestConnexionJDBC.java
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

class TestConnexionJDBC
{
  public static void main(String[] args)
  {
    Connection connexion = null;
    try
    {
      // Chargement de la classe du driver JDBC de MySQL
      Class.forName("com.mysql.jdbc.Driver");
      // Ouverture de la connexion avec MySQL tournant sur la meme machine
      connexion = DriverManager.getConnection("jdbc:mysql:///test");
      JOptionPane.showMessageDialog(null, "Connexion Ok");
    }
    catch (ClassNotFoundException ex)
    {
      // Exception declenchee si la classe n'est pas chargee par forName
      JOptionPane.showMessageDialog(null, "Classe introuvable " + ex.getMessage());
    }
    catch (SQLException ex)
    {
      // Exception declenchee en cas de probleme avec le SGBD
      JOptionPane.showMessageDialog(null, "Connexion impossible : " + ex.getMessage());
    }
    finally
    {
      try
      {
        if (connexion != null)
          connexion.close(); // Fermeture de la connexion
      }
      catch (SQLException ex)
      {
        ex.printStackTrace();
      }
    }
  }
}
