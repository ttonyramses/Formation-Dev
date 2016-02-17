/*
 * Fichier com/eteks/test/ConversionSommeMontantsEuro.java
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

import com.eteks.outils.ConvertisseurEuro;

class ConversionSommeMontantsEuro
{
  public static void main(String[] args)
  {
    double montant1 = 3.38;
    double montant2 = 30.87;
    // L'operateur de conversion est plus prioritaire que les operateurs arithmetiques
    float montantTotal = (float)(montant1 + montant2);
    // L'operateur new a la meme priorite que l'operateur . ce qui
    // permet d'appeler une methode sur un nouvel objet sans utiliser de parentheses
    float montant1Franc =
            new ConvertisseurEuro((float)montant1).getMontantEnFranc();
    float montant2Franc =
            new ConvertisseurEuro((float)montant2).getMontantEnFranc();
    float montantTotalFranc = new ConvertisseurEuro(montantTotal).getMontantEnFranc();
    // L'operateur + permet de concatener plus facilement des chaines de caracteres
    String message =
      "La somme de deux montants convertis en \u20ac peut "
      + "\u00eatre differente de leur somme convertie "
      + "en \u20ac :\n"; // \n est le code du retour a la ligne
    // La reference message peut etre reutilisee pour recuperer le message concatene
    message = message + montant1 + " \u20ac + "
              + montant2 + " \u20ac est \u00e9gal \u00e0 "
              + montantTotal + " \u20ac\n";
    message = message + montant1Franc + " FF + "
              + montant2Franc + " FF est diff\u00e9rent de "
              + montantTotalFranc + " FF";
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
