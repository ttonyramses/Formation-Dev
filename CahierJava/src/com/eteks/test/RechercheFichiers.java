/*
 * Fichier com/eteks/test/RechercheFichiers.java
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

import com.eteks.outils.OutilsFichier;
import javax.swing.JOptionPane;
import java.io.File;

class RechercheFichiers
{
  public static void main(String[] args)
  {
    // Saisie du dossier et de l'extension des fichiers recherches
    String dossier = JOptionPane.showInputDialog("Dossier de recherche :");
    String extension = JOptionPane.showInputDialog("Extension :");
    File [] fichiers = OutilsFichier.chercherFichiersDossier(dossier, extension);
    // Affiche la liste des fichiers trouves
    JOptionPane.showMessageDialog(null, fichiers);
  }
}
