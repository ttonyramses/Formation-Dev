/*
 * Fichier com/eteks/forum/MessageForum.java
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

public class MessageForum extends Message
{
  private int id;

  public MessageForum(Utilisateur auteur, String sujet,
                      String texte)
  {
    super(auteur, sujet, texte);
  }

  public MessageForum()
  {
    this(null, null, null);
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public boolean rechercher(ConnecteurForum connecteur)
                                        throws SQLException
  {
    try (PreparedStatement rechercheMessage =
           connecteur.getConnexion().prepareStatement(
               "SELECT * FROM MESSAGE WHERE ID=?"))
    {
      rechercheMessage.setInt(1, this.id);
      try (ResultSet resultat = rechercheMessage.executeQuery()) 
      {
        boolean messageExiste = resultat.next();
        if (messageExiste)
        {
          setAuteur(resultat.getString("AUTEUR"));
          setDateCreation(resultat.getTimestamp("DATECREATION"));
          setSujet(resultat.getString("SUJET"));
          setTexte(resultat.getString("TEXTE"));
        }
        return messageExiste;
      }
    }
  }

  public void ajouter(ConnecteurForum connecteur)
                                        throws SQLException
  {
    try (PreparedStatement rechercheMaxIdMessage =
           connecteur.getConnexion().prepareStatement(
               "SELECT MAX(ID) FROM MESSAGE");
         ResultSet resultat = rechercheMaxIdMessage.executeQuery())
    {
      resultat.next();
      this.id = resultat.getInt(1) + 1;
    }
    try (PreparedStatement ajoutMessage =
           connecteur.getConnexion().prepareStatement(
               "INSERT INTO MESSAGE"
               + " (ID, AUTEUR, DATECREATION, SUJET, TEXTE) "
               + " VALUES (?, ?, ?, ?, ?)"))
    {
      ajoutMessage.setInt(1, this.id);
      ajoutMessage.setString(2, getAuteur());
      ajoutMessage.setTimestamp(3,
           new Timestamp(getDateCreation().getTime()));
      ajoutMessage.setString(4, getSujet());
      ajoutMessage.setString(5, getTexte());
      ajoutMessage.executeUpdate();
    }
  }

  public void mettreAJour(ConnecteurForum connecteur)
                                        throws SQLException
  {
    try (PreparedStatement miseAJourMessage =
           connecteur.getConnexion().prepareStatement(
               "UPDATE MESSAGE SET AUTEUR=?, DATECREATION=?,"
               + " SUJET=?, TEXTE=? WHERE ID=?"))
    {
      miseAJourMessage.setString(1, getAuteur());
      miseAJourMessage.setTimestamp(2,
          new Timestamp(getDateCreation().getTime()));
      miseAJourMessage.setString(3, getSujet());
      miseAJourMessage.setString(4, getTexte());
      miseAJourMessage.setInt(5, this.id);
      miseAJourMessage.executeUpdate();
    }
  }
}
