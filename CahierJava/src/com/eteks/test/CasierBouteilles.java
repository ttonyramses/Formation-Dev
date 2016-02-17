/*
 * Fichier com/eteks/test/CasierBouteilles.java
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


import javax.swing.JOptionPane;

class CasierBouteilles
{
  public static void main(String[] args)
  {
    // Creation d'instances de boisson
    Boisson soda = new Boisson("Soif !", 2);
    Boisson bordeaux =
      new BoissonAlcoolisee("Bordeaux",
                            4.5f, 12);
    // Creation d'un casier de 9 boissons
    Boisson [] casier = new Boisson [9];
    // Affectation des boissons aux cases
    casier [0] = soda;
    casier [1] = soda;
    // La 3eme et la 4eme cases sont vides


    // Ajout de 4 bouteilles de Bordeaux
    for (int i = 4; i <= 7; i++)
      casier [i] = bordeaux;
    // Affectation de la 4eme place
    casier [3] =
               new Boisson("Limonade ", 2);
    // Calcul et affichage du prix du casier
    // et du nombre de cases libres
    float prix = 0;
    int   casesLibres = 0;
    for (Boisson boisson : casier)
    {
      if (boisson != null)
        prix += boisson.getPrix();
      else
        casesLibres++;
    }
    JOptionPane.showMessageDialog(null,
      "Valeur du casier "+ prix +" \u20AC"
      +"\n"+ casesLibres + " cases libres");
  }
}
