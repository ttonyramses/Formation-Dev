/*
 * Fichier com/eteks/test/SuppressionCommentairesFichier.java
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

import com.eteks.outils.FiltreCommentaires;
import javax.swing.JOptionPane;
import java.io.*;

class SuppressionCommentairesFichier
{
  public static void main(String[] args)
  {
    // Saisie du fichier a filtrer
    String cheminFichier = JOptionPane.showInputDialog("Fichier \u00e0 filtrer :");
    // Saisie du fichier de sauvegarde du filtrage avec proposition d'un nom par defaut
    String cheminFichierSauvegarde =
        JOptionPane.showInputDialog("Fichier de sauvegarde :", cheminFichier + ".txt");
    // Ouverture des fichiers dont l'acces est optimise avec une memoire tampon
    // Le filtre sur les commentaires est applique sur le fichier en lecture
    try (Reader fluxLecture  = new FiltreCommentaires(
                       new BufferedReader(new FileReader(cheminFichier)));
         Writer fluxEcriture = new BufferedWriter(new FileWriter(cheminFichierSauvegarde)))
    {
      // Recopie filtree du contenu du fichier en lecture dans le fichier en ecriture
      for (int c = fluxLecture.read(); c != -1; c = fluxLecture.read())
        fluxEcriture.write(c);
    }
    catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, ex);
    }
  }
}
