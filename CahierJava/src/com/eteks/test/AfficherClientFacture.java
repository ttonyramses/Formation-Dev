/*
 * Fichier com/eteks/forum/AfficherClientFacture.java
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
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

class AfficherClientFacture
{
  public static void main(String[] args)
  {
    try
    {
      // Instanciation d'une factory d'analyseurs DOM
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      // Instanciation d'un analyseur DOM
      DocumentBuilder builder = factory.newDocumentBuilder();
      // Analyse du fichier facture.xml
      Document document = builder.parse("facture.xml");

      // Recherche dans le document du premier element denomme client
      NodeList elements = document.getElementsByTagName("client");
      Element elementClient = (Element)elements.item(0);
      // Recuperation de l'attribut nom
      String message = "Client : \n" + elementClient.getAttribute("nom");
      // Recuperation de l'adresse stockee dans les donnees textuelles de l'element
      Text donneesTexte = (Text)elementClient.getFirstChild();
      message += donneesTexte.getData();

      // Affiche Client : Albert Dupont 3, rue du pont 75001 PARIS
      JOptionPane.showMessageDialog(null, message);
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
