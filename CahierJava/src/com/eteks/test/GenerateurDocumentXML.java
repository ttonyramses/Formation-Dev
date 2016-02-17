/* 
 * Fichier com/eteks/test/GenerateurDocumentXML.java 
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

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

class GenerateurDocumentXML
{
  public static void main(String[] args)
  {
    try
    {
      // Creation d'un nouveau document DOM avec un element facture a la racine 
      Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder ().newDocument();
      Element facture = document.createElement("facture");
      document.appendChild(facture);
      facture.setAttribute("montant", "20.80");
      facture.appendChild(document.createElement("client"));
      // Instanciation d'un transformateur de copie
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      // Indentation des elements dans le document
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      // Transformation du fichier factureDOM.xml
      transformer.transform(new DOMSource(document), new StreamResult(new File("factureDOM.xml")));  
    }
    catch (ParserConfigurationException | TransformerException ex)
    {
      JOptionPane.showMessageDialog(null, "Probl\u00e8me de transformation : " + ex.getMessage());
    }
  }
}
