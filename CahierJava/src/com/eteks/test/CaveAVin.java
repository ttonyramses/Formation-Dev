/*
 * Fichier com/eteks/test/CaveAVin.java
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

import java.util.ArrayList;
import javax.swing.JOptionPane;

class CaveAVin
{
  public static void main(String[] args)
  {
    // Creation d'instances de boisson
    Boisson soda = new Boisson("Soif !", 2);
    Boisson bordeaux =
      new BoissonAlcoolisee("Bordeaux",
                            4.5f, 12);
    // Creation d'un ensemble illimite
    ArrayList<Boisson> caveAVin = 
        new ArrayList<>();
    // Ajout des boissons dans la cave a vin
    caveAVin.add(soda);
    caveAVin.add(soda);
    // La 3eme et la 4eme places sont vides
    caveAVin.add(null);
    caveAVin.add(null);
    // Ajout de 4 bouteilles de Bordeaux
    for (int i = 4; i <= 7; i++)
      caveAVin.add (bordeaux);
    // Affectation de la 4eme place
    caveAVin.set(3,
                 new Boisson("Limonade", 2));
    // Calcul et affichage du prix du casier
    // et du nombre de places laissees vide
    float prix = 0;
    int   placesVides = 0;
    for (Boisson boisson : caveAVin)
    {
      if (boisson != null)
        prix += boisson.getPrix();
      else
        placesVides++;
    }
    JOptionPane.showMessageDialog(null,
      "Valeur de la cave : "+ prix +" \u20AC"
      + "\n" + placesVides + " place vide");
  }
}
