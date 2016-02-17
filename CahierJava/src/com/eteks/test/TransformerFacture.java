/*
 * Fichier com/eteks/test/TransformerFacture.java 
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
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

class TransformerFacture
{
  public static void main(String[] args)
  {
    try
    {
      // Instanciation d'une factory de transformateurs
      TransformerFactory factory = TransformerFactory.newInstance();
      // Instanciation d'un transformateur associe a la transformation articlesFacture.xsl
      Transformer transformer = factory.newTransformer(
          new StreamSource(new File("articlesFacture.xsl")));
      // Transformation du fichier facture.xml
      StringWriter result = new StringWriter(); 
      transformer.transform(new StreamSource(new File("facture.xml")), 
          new StreamResult(result));
      // Affiche le document HTML resultant
      JOptionPane.showMessageDialog(null, result.toString().replace('\n', ' '));
    }
    catch (TransformerException ex)
    {
      JOptionPane.showMessageDialog(null, 
          "Probl\u00e8me de transformation : " + ex.getMessage());
    }
  }
}
