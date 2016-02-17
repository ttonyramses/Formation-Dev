/*
 * Fichier com/eteks/test/CalculLignesDeCode.java
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

import com.eteks.outils.*;
import javax.swing.JOptionPane;
import java.io.*;

class CalculLignesDeCode
{
  public static void main(String[] args)
  {
    try
    {
      // Saisie du dossier des fichiers recherches
      String dossier = JOptionPane.showInputDialog("Dossier de recherche :");
      // Recherche des fichiers .java dans le dossier
      File [] fichiers = OutilsFichier.chercherFichiersDossier(dossier, ".java");
      // Decompte du nombre de ligne de codes pour chaque fichier
      int nombreLignesCodeTotal = 0;
      for (int i = 0; i < fichiers.length; i++)
        nombreLignesCodeTotal += compterLignesDeCode(fichiers[i]);

      JOptionPane.showMessageDialog(null,
           nombreLignesCodeTotal + " lignes de code dans les " + fichiers.length
           + " fichiers java du dossier\n" + new File(dossier).getCanonicalPath()
           + "\n(hors lignes vides et commentaires)");
    }
    catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }

  public static int compterLignesDeCode(File cheminFichier) throws IOException
  {
    // Ouverture du fichier avec un filtre sur les commentaires
    try (BufferedReader fluxLecture = new BufferedReader(
        new FiltreCommentaires(
            new BufferedReader(new FileReader(cheminFichier)))))
    {
      int nombreLignesCode = 0;
      // Lecture ligne par ligne du fichier
      for (String ligne = fluxLecture.readLine();
           ligne != null;
           ligne = fluxLecture.readLine())
        // Incrementation du nombre de lignes si la ligne lue
        // sans espace de debut et de fin n'est pas vide
        if (ligne.trim().length() > 0)
          nombreLignesCode++;
      return nombreLignesCode;
    }
  }
}
