/*
 * Fichier com/eteks/outils/Personne.java
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
package com.eteks.outils;

public class Personne
{
  private String  nom;     // Champ memorisant le nom d'une personne
  private String  prenom;  // Champ memorisant le prenom d'une personne
  private Adresse adresse; // Champ memorisant l'adresse d'une personne

  public Personne(String nom, String prenom)
  {
    this.nom    = nom;
    this.prenom = prenom;
  }

  public String getNom()
  {
    return this.nom;
  }

  public String getPrenom()
  {
    return this.prenom;
  }

  /**
   * Modifie l'adresse de cette personne.
   */
  public void setAdresse(Adresse adresse)
  {
    this.adresse = adresse;
  }

  /**
   * Renvoie l'adresse de cette personne.
   */
  public Adresse getAdresse()
  {
    return this.adresse;
  }
}
