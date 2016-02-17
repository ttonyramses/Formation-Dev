/*
 * Fichier com/eteks/forum/EnsembleMessagesForum.java
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
import java.util.*;

public class EnsembleMessagesForum implements Iterable<MessageForum>
{
  private ArrayList<MessageForum> messages = new ArrayList<>();

  /**
   * Ajoute un message a cet ensemble.
   */
  public void ajouter(MessageForum message)
  {
    this.messages.add(message);
  }

  /**
   * Renvoie un iterateur permettant d'enumerer les messages
   * de cet ensemble.
   */
  public Iterator<MessageForum> iterator()
  {
    return this.messages.iterator();
  }

  public void rechercherSujets(ConnecteurForum connecteur)
                                         throws SQLException
  {
    try (PreparedStatement rechercheSujets =
           connecteur.getConnexion().prepareStatement(
             "SELECT ID, AUTEUR, MAX(DATECREATION) AS DATECREATION,"
             + " SUJET, TEXTE FROM MESSAGE GROUP BY SUJET"
             + " ORDER BY DATECREATION DESC")) 
    {
      rechercher(rechercheSujets, null);
    }
  }

  public void rechercherMessagesSujet(ConnecteurForum connecteur,
                         String sujet) throws SQLException
  {
    try (PreparedStatement rechercheMessagesSujet =
           connecteur.getConnexion().prepareStatement(
             "SELECT * FROM MESSAGE"
             + " WHERE SUJET=? ORDER BY DATECREATION ASC"))
    {
      rechercher(rechercheMessagesSujet, new Object [] {sujet});
    }
  }

  private void rechercher(PreparedStatement instructionRecherche,
                         Object [] parametresInstruction)
                                             throws SQLException
  {
    if (parametresInstruction != null)
      for (int i = 0; i < parametresInstruction.length; i++)
        instructionRecherche.setObject(
                               i + 1, parametresInstruction [i]);
    try (ResultSet resultat = instructionRecherche.executeQuery())
    {
      while (resultat.next())
      {
        MessageForum message = new MessageForum();
        message.setId(resultat.getInt("ID"));
        message.setAuteur(resultat.getString("AUTEUR"));
        message.setDateCreation(
                           resultat.getTimestamp("DATECREATION"));
        message.setSujet(resultat.getString("SUJET"));
        message.setTexte(resultat.getString("TEXTE"));
        ajouter(message);
      }
    }
  }
}
