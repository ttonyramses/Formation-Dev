/*
 * Fichier com/eteks/test/CalculFactorielle.java
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
class CalculFactorielle
{
  public static void main(String [] args)
  {
    String s = null;
    do
    {
      // Saisie d'un texte avec une boite de dialogue Ok / Annuler
      s = JOptionPane.showInputDialog("Entrez un nombre :");
      if (s != null) // s est egal a null si l'utilisateur a choisi Annuler
      {
        long n = Long.parseLong(s); // Conversion du texte saisi en nombre
        long factN = Calcul.factorielle(n); // Calcul de la factorielle
        JOptionPane.showMessageDialog(null, n + "! = " + factN);
      }
    }
    while (s != null);
  }
}

class Calcul
{
  /**
   * Renvoie la factorielle de n, egale a n x (n - 1) x (n - 2) x ... x 2 x 1
   * @exception IllegalArgumentException si n < 0 ou n > 20
   */
  public static long factorielle(long n)
  {
    // Verification des cas limites
    if (n < 0 || n > 20)
      throw new IllegalArgumentException(n + " invalide");
    // Condition d'arret
    if (n <= 1)
      return 1;
    else
      // Appel recursif a factorielle
      return n * factorielle(n - 1);
  }
}
