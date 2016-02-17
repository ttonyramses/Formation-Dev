/*
 * Fichier com/eteks/test/CalculOccurrencesCaractere.java
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
import java.io.*;

class CalculOccurrencesCaractere
{
  public static void main(String[] args)
  {
    String cheminFichier = JOptionPane.showInputDialog("Fichier :");
    // Saisie du fichier et du caractere recherche
    char caractere = JOptionPane.showInputDialog("Caract\u00e8re :").charAt(0);
    // Ouverture du fichier saisi
    try (Reader fluxFichier = new FileReader(cheminFichier))
    {
      int occurrences = 0;
      int c;
      do
      {
        c = fluxFichier.read(); // Lire un caractere...
        if (c != -1 && caractere == (char)c)
          occurrences++;
      }
      while (c != -1); // ...tant que la fin du fichier n'est pas atteinte
      JOptionPane.showMessageDialog(null,
        "'" + caractere + "' trouv\u00e9 " + occurrences + " fois dans " + cheminFichier);
    }
    catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
}
