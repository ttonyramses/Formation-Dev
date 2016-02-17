/*
 * Fichier com/eteks/outils/OutilsFichier.java
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
package com.eteks.outils;

import java.util.TreeSet;
import java.io.*;

public class OutilsFichier
{
  /**
   * Renvoie la liste des fichiers du dossier en parametre.
   */
  public static File [] chercherFichiersDossier(String dossier, String extension)
  {
    File chemin = new File(dossier);
    // Si le dossier n'existe pas ou si c'est un fichier, declenchement d'une exception
    if (   !chemin.exists()
        || !chemin.isDirectory())
      throw new IllegalArgumentException(dossier + " inconnu");
    // Recherche recursive des fichiers a partir du dossier
    TreeSet<File> fichiersTries = new TreeSet<>();
    chercherFichiersDossier(fichiersTries, chemin, extension);
    // Recopie des fichiers trouves dans un tableau de meme dimension
    File [] fichiers = new File [fichiersTries.size()];
    fichiersTries.toArray(fichiers);
    return fichiers;
  }

  private static void chercherFichiersDossier(TreeSet<File> fichiers,
                                              File cheminDossier, String extension)
  {
    // Recherche des sous-dossiers et des fichiers de bonne extension avec le filtre
    for (File chemin : cheminDossier.listFiles())
      // Si le chemin est un dossier
      if (chemin.isDirectory())
        // Recherche recursive des fichiers a partir de ce sous-dossier
        chercherFichiersDossier(fichiers, chemin, extension);
      // Sinon ajout du fichier d'extension voulue a l'ensemble
      else if (chemin.getName().endsWith(extension))
        fichiers.add(chemin);
  }
}
