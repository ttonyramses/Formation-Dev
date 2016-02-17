/*
 * Fichier com/eteks/test/AfficherEmployesSociete.java
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
import javax.xml.bind.JAXB;
import com.eteks.outils.*;

class AfficherEmployesSociete
{
  public static void main(String[] args)
  {
    Societe societe = JAXB.unmarshal(new File("societe.xml"), Societe.class);
    String message = "Employ\u00e9s de " + societe.getNom() + " :\n";
    for (Employe employe : societe.getEmployes())
    {
      message += employe.getNom() + " " + employe.getPrenom() + "\n";
    }
    JOptionPane.showMessageDialog(null, message);
  }
}
