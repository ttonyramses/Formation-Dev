/*
 * Fichier com/eteks/forum/UtilisateurForum.java
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

public class UtilisateurForum extends Utilisateur
{
  public UtilisateurForum(String pseudonyme, String motDePasse,
                          Autorisation autorisation)
  {
    super (pseudonyme, motDePasse, autorisation);
  }

  public UtilisateurForum()
  {
    this (null, null, null);
  }

  public boolean rechercher(ConnecteurForum connecteur)
                                            throws SQLException
  {
    try (PreparedStatement rechercheUtilisateur =
           connecteur.getConnexion().prepareStatement(
               "SELECT * FROM UTILISATEUR WHERE PSEUDONYME=?"))
    {
      rechercheUtilisateur.setString(1, getPseudonyme());
      try (ResultSet resultat = rechercheUtilisateur.executeQuery()) 
      {
        boolean utilisateurExiste = resultat.next();
        if (utilisateurExiste)
        {
          setMotDePasse(resultat.getString("MOTDEPASSE"));
          String autorisation = resultat.getString("AUTORISATION");
          if (autorisation != null)
            switch (autorisation)
            {
              case "M" : 
                setAutorisation(Autorisation.MODERATEUR);
                break;
              case "U" : 
                setAutorisation(Autorisation.UTILISATEUR);
                break;
            }
        }
        return utilisateurExiste;
      }
    }
  }

  public void ajouter(ConnecteurForum connecteur)
                                        throws SQLException
  {
    try (PreparedStatement ajoutUtilisateur =
           connecteur.getConnexion().prepareStatement(
               "INSERT INTO UTILISATEUR"
                + " (PSEUDONYME, MOTDEPASSE, AUTORISATION)"
                + " VALUES (?, ?, ?)"))
    {
      ajoutUtilisateur.setString(1, getPseudonyme());
      ajoutUtilisateur.setString(2, getMotDePasse());
      ajoutUtilisateur.setString(3, 
          getAutorisation().toString().substring(0, 1));
      ajoutUtilisateur.executeUpdate();
    }
  }
}

