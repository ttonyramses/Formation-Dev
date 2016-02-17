/*
 * Fichier com/eteks/test/AfficherUtilisateursXML.java
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

import com.eteks.forum.*;
import java.io.*;
import java.util.*;

class AfficherUtilisateursXML
{
  public static void main(String[] args)
  {
    // Ouverture d'un flux de lecture sur le fichier utilisateurs.xml
    try (InputStream fluxLecture = new FileInputStream("utilisateurs.xml"))
    {
      // Analyse des utilisateurs du document XML
      AnalyseurXMLForum analyseurXML = new AnalyseurXMLForum();
      Set<Utilisateur> utilisateurs = analyseurXML.lireUtilisateursXML(fluxLecture);
      // Construction d'un texte avec tous les utilisateurs trouves
      String texte = "";
      for (Utilisateur utilisateur : utilisateurs)
        texte += "\u25cf " + utilisateur + "\n";
      javax.swing.JOptionPane.showMessageDialog(null, texte);
    }
    catch (IOException ex)
    {
      javax.swing.JOptionPane.showMessageDialog(null, ex);
    }
  }
}
