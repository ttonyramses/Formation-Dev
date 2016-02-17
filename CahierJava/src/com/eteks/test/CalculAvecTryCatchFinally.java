/*
 * Fichier com/eteks/test/CalculAvecTryCatchFinally.java
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

class CalculAvecTryCatchFinally
{
  public static void main(String [] args)
  {
    String titre = "Calcul de factorielle"; // Titre des boites de dialogue
    int    reponse;
    String s = null;
    do
      try
      {
        s = JOptionPane.showInputDialog(null, "Entrez un nombre :",
                                        titre, JOptionPane.OK_CANCEL_OPTION);
        if (s != null)
        {
          // La conversion du texte saisi en nombre peut declencher
          // une exception de classe java.lang.NumberFormatException
          long n = Long.parseLong(s);
          // L'appel a factorielle peut declencher
          // une exception de classe java.lang.IllegalArgumentException
          long factN = Calcul.factorielle(n);
          JOptionPane.showMessageDialog(null, n + "! = " + factN);
        }
      }
      catch (NumberFormatException ex)
      {
        JOptionPane.showMessageDialog(null, s + " n'est pas un entier",
                                      titre, JOptionPane.ERROR_MESSAGE);
      }
      catch (IllegalArgumentException ex)
      {
        JOptionPane.showMessageDialog(null, ex.getMessage (),
                                      titre, JOptionPane.ERROR_MESSAGE);
      }
      finally
      {
        // Demande de confirmation pour quitter
        reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter ?",
                                                titre, JOptionPane.YES_NO_OPTION);
      }
    while (reponse == JOptionPane.NO_OPTION);
  }
}
