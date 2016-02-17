/*
 * Fichier com/eteks/test/ValeursMathematiques.java
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

class ValeursMathematiques
{
  public static void main(String[] args)
  {
    // Le caractere Unicode de la lettre grecque pi est \u03c0
    String texte = "\u03c0 = " + Math.PI + "\n";
    texte += "e = " + Math.E + "\n";

    double sinPiSur4 = Math.sin(Math.PI / 4.);
    texte += "sin (\u03c0 / 4) = " + sinPiSur4 + "\n";
    double racineDe2Sur2 = Math.sqrt(2.) / 2.;
    // Le caractere Unicode du symbole de la racine carree est \u221a
    texte += "\u221a 2 / 2 = " + racineDe2Sur2 + "\n";

    double logNeperienDeE = Math.log(Math.E);
    texte += "ln (e) = " + logNeperienDeE;

    javax.swing.JOptionPane.showMessageDialog(null, texte);
  }
}
