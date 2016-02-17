/*
 * Fichier com/eteks/outils/Adresse.java
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

public class Adresse
{
  private String rue;        // Champ memorisant la rue et son numero
  private int    codePostal; // Champ memorisant le code postal
  private String ville;      // Champ memorisant la ville d'une adresse

  public Adresse(String rue, int codePostal, String ville)
  {
    this.rue        = rue;
    this.codePostal = codePostal;
    this.ville      = ville;
  }

  public java.lang.String getRue()
  {
    return this.rue;
  }

  public int getCodePostal()
  {
    return this.codePostal;
  }

  public java.lang.String getVille()
  {
    return this.ville;
  }
}
