/*
 * Fichier com/eteks/outils/Figure.java
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

/**
 * Figure avec une couleur et une surface calculee dans les sous classes.
 */
public abstract class Figure
{
  private String couleur; // Champ memorisant la couleur d'une figure

  public Figure(String couleur)
  {
    this.couleur = couleur;
  }

  /**
   * Renvoie la surface de cette figure. Une sous classe de Figure doit
   * redefinir getSurface pour renvoyer sa surface suivant le type
   * de figure qu'elle represente.
   */
  public abstract float getSurface();

  /**
   * Renvoie la couleur et la surface de cette figure sous forme textuelle.
   */
  public String toString()
  {
    // Le texte renvoye depend de l'implementation de la methode getSurface
    // programmee dans les sous classes de Figure
    return "Figure " + this.couleur + " (" + getSurface() + " m\u00b2)";
  }
}
