/*
 * Fichier com/eteks/test/AfficherSujets.java
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

import com.eteks.forum.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class AfficherSujets
{
  public static void main(String[] args)
  {
    UtilisateurForum moderateur = new UtilisateurForum(
      "moderateur", "azerty", Autorisation.MODERATEUR);
    MessageForum message1 = new MessageForum(
      moderateur, "Bienvenue",
      "Bonjour \u00e0 tous, ce forum mod\u00e9r\u00e9 permet aux"
      + " inscrits de poser des questions ou de r\u00e9pondre.");
    MessageForum message2 = new MessageForum(
      moderateur, "Livre Java",
      "Quel livre me conseillez-vous pour apprendre Java ?");
    try
    {
      ConnecteurForum connecteur = new ConnecteurForum();
      moderateur.ajouter(connecteur);
      message1.ajouter(connecteur);
      message2.ajouter(connecteur);
      EnsembleMessagesForum sujets = new EnsembleMessagesForum();
      sujets.rechercherSujets(connecteur);
      String listeSujets = "Liste des sujets du forum :";
      for (Message message : sujets)
      {
        listeSujets += "\n \u25aa " + message.getSujet();
      }
      JOptionPane.showMessageDialog(null, listeSujets);
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null,
             "Erreur JDBC : " + ex.getMessage());
    }
  }
}
