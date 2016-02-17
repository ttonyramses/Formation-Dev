/*
 * Fichier com/eteks/test/AfficherContenuURL.java
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

import javax.swing.*;
import java.io.*;
import java.net.*;

class AfficherContenuURL
{
  public static void main (String [] args)
  {
    String texteURL = null;
    try
    {
      // Saisie d'une URL et creation d'un objet de classe java.net.URL
      texteURL = JOptionPane.showInputDialog("URL :");
      URL url = new URL(texteURL);
      // Creation d'un composant javax.swing.JEditorPane non editable
      // capable de lire et d'afficher le contenu d'URL au format texte ou HTML
      JEditorPane panneauHTML = new JEditorPane(url);
      panneauHTML.setEditable(false);
      // Affichage du composant dans un panneau avec ascenseurs d'une fenetre
      JFrame fenetre = new JFrame(texteURL);
      fenetre.setSize(400, 300);
      fenetre.add(new JScrollPane(panneauHTML));
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setVisible(true);
    }
    catch (MalformedURLException ex)
    {
      JOptionPane.showMessageDialog(null, "URL " + texteURL + " incorrecte");
      System.exit(0);
    }
    catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null,
         "Erreur d'acc\u00e8s \u00e0 l'URL " + texteURL + "\n" + ex);
      System.exit(0);
    }
  }
}
