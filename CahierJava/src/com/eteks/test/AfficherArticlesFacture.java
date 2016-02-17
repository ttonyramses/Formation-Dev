/*
 * Fichier com/eteks/forum/AfficherArticlesFacture.java
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
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

class AfficherArticlesFacture
{
  public static void main(String[] args)
  {
    try
    {
      // Instanciation d'une factory d'analyseurs SAX
      SAXParserFactory factory = SAXParserFactory.newInstance();
      // Instanciation d'un analyseur SAX
      SAXParser parser = factory.newSAXParser();
      // Ensemble stockant les articles trouves dans le fichier XML
      final ArrayList<String> articles = new ArrayList<>();
      // Creation d'un gestionnaire SAX avec une sous-classe anonyme
      DefaultHandler gestionnaireSAX = new DefaultHandler()
        {
          // Redefinition de la methode appelee quand une balise de debut est lue
          public void startElement(String namespaceURI,
                                   String localName,
                                   String nom,
                                   Attributes attributs)
          {
            // Recuperation de la description des articles
            if ("article".equals (nom))
            {
              String description = attributs.getValue("description");
              articles.add(description);
            }
          }
        };
      // Analyse du fichier facture.xml avec le gestionnaire precedent
      parser.parse("facture.xml", gestionnaireSAX);
      // Affiche : Articles [CDRx10, Papier A4]
      JOptionPane.showMessageDialog(null, "Articles " + articles);
    }
    catch (ParserConfigurationException 
           | SAXException 
           | IOException ex)
    {
      JOptionPane.showMessageDialog(null, 
          "Probl\u00e8me : " + ex.getMessage());
    }
  }
}
