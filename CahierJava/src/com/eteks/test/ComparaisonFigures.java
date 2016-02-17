/*
 * Fichier com/eteks/test/ComparaisonFigures.java
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

import com.eteks.outils.Figure;

class Rectangle extends Figure
{
  private float longueur;
  private float largeur;

  public Rectangle(String couleur, float longueur, float largeur)
  {
    super(couleur);
    this.longueur = longueur;
    this.largeur  = largeur;
  }

  @Override
  public float getSurface()
  {
    return this.longueur * this.largeur;
  }
}

class Cercle extends Figure
{
  private float rayon;

  public Cercle(String couleur, float rayon)
  {
    super(couleur);
    this.rayon = rayon;
  }

  @Override
  public float getSurface()
  {
    return (float)Math.PI * this.rayon * this.rayon;
  }
}

class ComparaisonFigures
{
  public static void main(String[] args)
  {
    // Instanciation de 2 rectangles et d'un cercle
    Rectangle  rectangleJaune = new Rectangle("jaune", 20, 10);
    Rectangle  rectangleRouge = new Rectangle("rouge", 2, 1.5f);
    Cercle cercleBleu = new Cercle("bleu", 5);

    // Affichage des figures les plus grandes
    // conversions implicites des references autorisees car les classes de rectangleJaune,
    // rectangleRouge et cercleBleu sont des sous classes de com.eteks.test.Figure
    afficherLaPlusGrande(rectangleJaune, rectangleRouge);
    afficherLaPlusGrande(rectangleRouge, cercleBleu);
  }

  // Affiche un message decrivant quelle est la plus grande des deux figures f1 et f2
  public static void afficherLaPlusGrande(Figure f1, Figure f2)
  {
    String message;
    // Appel des methodes getSurface implementees dans les sous classes
    if (f1.getSurface() > f2.getSurface())
      message = f1 + " est plus grand que " + f2;
    else
      message = f2 + " est plus grand que " + f1;

    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
