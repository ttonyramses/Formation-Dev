/*
 * Fichier com/eteks/test/CalculProbabilites.java
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

import com.eteks.outils.Probabilite;

class CalculProbabilites
{
  public static void main(String[] args)
  {
    // Creation d'une instance de la classe com.eteks.test.Probabilite
    // pour appeler les methodes de calcul de probabilite
    Probabilite probabilite = new Probabilite();
    long nombreCombinaisons32bits = probabilite.arrangementsAvecRepetition(2, 32);
    long nombreTiercesAvecOrdre   = probabilite.arrangementsSansRepetition(20, 3);
    long nombreArrivees100m       = probabilite.permutations(10);
    long nombreGrillesLoto        = probabilite.combinaisons(49, 6);

    // Affichage des valeurs calculees
    String message =
      "Nombre de combinaisons possibles avec 32 bits : "
      + nombreCombinaisons32bits
      + "\nNombre de tierc\u00e9s dans l'ordre"
      + " avec 20 chevaux au d\u00e9part : "
      + nombreTiercesAvecOrdre
      + "\nNombre d'arriv\u00e9es"
      + " avec 10 coureurs au d\u00e9part : "
      + nombreArrivees100m
      + "\nNombre de tirages possibles du loto : "
      + nombreGrillesLoto;
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
