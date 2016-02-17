/*
 * Fichier com/eteks/forum/ValiderDocumentXML.java
 *
 * Copyright (C) 2004-2006 Emmanuel PUYBARET / eTeks <info@eteks.com>. All Rights Reserved.
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
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

class ValiderDocumentXML
{
  public static void main(String[] args)
  {
    try
    {
      // Saisie du fichier XML
      String documentXML = JOptionPane.showInputDialog("Fichier XML :");
      // Recherche des erreurs dans le fichier XML
      ArrayList<SAXParseException> erreurs = chercherErreurs(documentXML);
      if (erreurs.size() == 0)
        JOptionPane.showMessageDialog(null, "Le fichier " + documentXML + " est valide");
      else
      {
        // Creation d'un rapport citant ligne par ligne les erreurs trouvees
        String rapport = "Le fichier " + documentXML + " est invalide :";
        for (SAXParseException ex : erreurs)
          rapport += "\n\u25cf ligne " + ex.getLineNumber() + " : " + ex.getMessage();
        JOptionPane.showMessageDialog(null, rapport);
      }
    }
    catch (ParserConfigurationException 
           | SAXException 
           | IOException ex)
    {
      JOptionPane.showMessageDialog(null, "Probl\u00e8me : " + ex.getMessage());
    }
  }

  private static ArrayList<SAXParseException> chercherErreurs(String documentXML)
    throws ParserConfigurationException, SAXException, IOException
  {
    // Instanciation d'une factory d'analyseurs SAX
    SAXParserFactory factory = SAXParserFactory.newInstance();
    // Instanciation d'un analyseur SAX validant les documents lus
    factory.setValidating(true);
    SAXParser parser = factory.newSAXParser();
    // Ensemble stockant les erreurs trouvees dans le fichier XML
    final ArrayList<SAXParseException> erreurs = new ArrayList<>();
    // Creation d'un gestionnaire SAX
    DefaultHandler gestionnaireSAX = new DefaultHandler()
      {
        // Redefinition des methodes de gestion d'erreur
        public void warning(SAXParseException ex)
        {
          erreurs.add(ex);
        }

        public void error(SAXParseException ex)
        {
          erreurs.add(ex);
        }

        public void fatalError(SAXParseException ex)
        {
          erreurs.add(ex);
        }
      };
    try
    {
      // Analyse du fichier avec le gestionnaire precedent
      parser.parse(documentXML, gestionnaireSAX);
    }
    catch (SAXParseException ex)
    {
      // Vraiment rien a faire, car l'erreur a deja ete signalee par un appel a fatalError
    }
    return erreurs;
  }
}
